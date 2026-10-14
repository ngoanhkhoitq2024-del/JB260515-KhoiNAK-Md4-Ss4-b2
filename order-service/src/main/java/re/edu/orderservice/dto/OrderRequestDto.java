package re.edu.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDto {
    @NotNull(message = "customerId không được để trống")
    @Min(value = 1, message = "customerId phải lớn hơn 0")
    private Long customerId;

    @NotNull(message = "productId không được để trống")
    @Min(value = 1, message = "productId phải lớn hơn 0")
    private Long productId;

    @NotNull(message = "quantity không được để trống")
    @Min(value = 1, message = "quantity phải lớn hơn 0")
    private Integer quantity;
}
