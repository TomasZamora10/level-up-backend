package Level_Up_backend.services.Products;

import Level_Up_backend.Models.products.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product getProductById(Long id);
    Product save(Product product);
    void delete(Long id);
}
