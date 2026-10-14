package re.edu.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
