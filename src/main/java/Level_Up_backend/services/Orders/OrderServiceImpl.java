package Level_Up_backend.services.Orders;

import Level_Up_backend.Models.orders.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    private static final double DUOC_DISCOUNT_RATE = 0.20;

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Orden con ID " + id + " no encontrada.")
        );
    }

    @Override
    @Transactional
    public Order createOrder(OrderRequestDTO orderDto) {

        User client = userRepository.findById(orderDto.getClientId()).orElseThrow(
                () -> new RuntimeException("Cliente con ID " + orderDto.getClientId() + " no encontrado.")
        );

        Order newOrder = new Order();
        newOrder.setClient(client);
        newOrder.setDireccionEnvio(orderDto.getDireccionEnvio());

        newOrder.setAplicaDescuentoDuoc(orderDto.getAplicaDescuentoDuoc());
        newOrder.setEstado("Pendiente");

        List<OrderDetail> orderDetails = new ArrayList<>();
        double total = 0.0;

        for (ItemDTO itemDto : orderDto.getItems()) {

            // Se busca el producto, si no existe lanza RuntimeException
            Product product = productService.findById(itemDto.getProductId()).orElseThrow(
                    () -> new RuntimeException("Producto con ID " + itemDto.getProductId() + " no encontrado.")
            );

            double unitPrice = product.getPrecio().doubleValue();

            if (newOrder.getAplicaDescuentoDuoc()) {
                unitPrice = unitPrice * (1.0 - DUOC_DISCOUNT_RATE);
            }

            if (product.getStock() < itemDto.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());
            }

            OrderDetail detail = new OrderDetail();
            detail.setOrder(newOrder);
            detail.setProduct(product);
            detail.setCantidad(itemDto.getCantidad());
            detail.setPrecioUnitario(unitPrice);

            orderDetails.add(detail);

            total += unitPrice * itemDto.getCantidad();

            product.setStock(product.getStock() - itemDto.getCantidad());
        }

        newOrder.setTotal(total);
        newOrder.setItems(orderDetails);

        return orderRepository.save(newOrder);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Orden con ID " + id + " no encontrada para eliminar.");
        }
        orderRepository.deleteById(id);
    }


}
