package uz.hojiakbar.service;


import uz.hojiakbar.dto.request.ProductRequestDto;
import uz.hojiakbar.dto.response.ProductResponseDto;
import uz.hojiakbar.model.Product;

import java.util.List;


public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto dto);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);

    ProductResponseDto updateProduct(ProductRequestDto dto, Long id);

    void deleteProduct(Long id);

    void updateProduct(Product product);
}
