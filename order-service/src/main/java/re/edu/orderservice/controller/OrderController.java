package re.edu.orderservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.orderservice.dto.OrderRequestDto;
import re.edu.orderservice.dto.OrderResponseDto;
import re.edu.orderservice.entity.Order;
import re.edu.orderservice.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(
            @Valid @RequestBody OrderRequestDto dto) {
        OrderResponseDto response = orderService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
