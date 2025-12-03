package Level_Up_backend.services.Orders;

import Level_Up_backend.Models.dtos.OrderRequestDTO;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(Long id);

    Order createOrder(OrderRequestDTO orderDto);

    void deleteOrder(Long id);
}
