package re.edu.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
