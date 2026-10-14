package re.edu.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.edu.productservice.dto.ProductRequestDto;
import re.edu.productservice.dto.ProductResponseDto;
import re.edu.productservice.entity.Product;
import re.edu.productservice.exception.ResourceNotFoundException;
import re.edu.productservice.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDto create(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());

        Product savedProduct = productRepository.save(product);

        return toResponseDTO(savedProduct);
    }

    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Không tìm thấy sản phẩm có id: " + id));

        return toResponseDTO(product);
    }

    public List<ProductResponseDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private ProductResponseDto toResponseDTO(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity()
        );
    }
}
