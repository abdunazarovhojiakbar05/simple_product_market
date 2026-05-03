package uz.hojiakbar.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.hojiakbar.repository.ProductRepository;
import uz.hojiakbar.dto.request.ProductRequestDto;
import uz.hojiakbar.dto.response.ProductResponseDto;
import uz.hojiakbar.mapper.ProductMapper;
import uz.hojiakbar.model.Product;
import uz.hojiakbar.service.AdminService;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

     private final ProductRepository productRepository;


    /**
     * @param dto
     * @return
     */
    @Override
    public ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto dto   ) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toResponseDto(savedProduct);
    }

    /**
     * @param quantity
     * @param
     * @return
     */
    @Override
    public ResponseEntity<ProductResponseDto> addProduct( Long quantity, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setQuantity(product.getQuantity() + quantity);
        productRepository.save(product);
        return ResponseEntity.ok(new ProductResponseDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()));
    }


}
