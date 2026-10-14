package re.edu.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequestDto {
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @Min(value = 1, message = "Giá sản phẩm phải lớn hơn hoặc bằng 1")
    private BigDecimal price;

    @Min(value = 0, message = "Số lượng tồn kho không được âm")
    private Integer stockQuantity;
}
