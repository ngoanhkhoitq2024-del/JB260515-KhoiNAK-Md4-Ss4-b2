package re.edu.orderservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.edu.orderservice.dto.OrderRequestDto;
import re.edu.orderservice.dto.OrderResponseDto;
import re.edu.orderservice.entity.Order;
import re.edu.orderservice.exception.ResourceNotFoundException;
import re.edu.orderservice.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponseDto create(OrderRequestDto dto) {

        // Giả lập giá sản phẩm lấy từ Product Service
        BigDecimal productPrice = new BigDecimal("100000");

        BigDecimal totalAmount = productPrice.multiply(
                BigDecimal.valueOf(dto.getQuantity())
        );

        Order order = new Order();
        order.setCustomerId(dto.getCustomerId());
        order.setProductId(dto.getProductId());
        order.setQuantity(dto.getQuantity());
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(totalAmount);

        Order savedOrder = orderRepository.save(order);

        return toResponseDto(savedOrder);
    }

    public OrderResponseDto getById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Không tìm thấy đơn hàng có id: " + id
                        ));
        return toResponseDto(order);
    }

    private OrderResponseDto toResponseDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getCustomerId(),
                order.getProductId(),
                order.getQuantity(),
                order.getOrderDate(),
                order.getTotalAmount()
        );
    }
}
