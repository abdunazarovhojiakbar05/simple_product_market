package uz.hojiakbar.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hojiakbar.repository.ProductRepository;
import uz.hojiakbar.dto.request.ProductRequestDto;
import uz.hojiakbar.dto.response.ProductResponseDto;
import uz.hojiakbar.model.Product;
import uz.hojiakbar.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    /**
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        Product product = new Product();
       updateProductFields(product, dto);
        productRepository.save(product);
        return new ProductResponseDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
    }

    /**
     * @return
     */
    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(
                product -> new ProductResponseDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getQuantity())
        ).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product1 = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        return mapToResponseDto(product1);
    }

    /**
     * @param dto
     * @param id
     * @return
     */
    @Override
    public ProductResponseDto updateProduct(ProductRequestDto dto, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        updateProductFields(product, dto);
         productRepository.save(product);
       return mapToResponseDto(product);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        productRepository.delete(product);
    }

    /**
     * @param product
     */
    @Override
    @Transactional
    public void updateProduct(Product product) {
        productRepository.save(product);
    }


    private void updateProductFields(Product product, ProductRequestDto dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
    }

    private ProductResponseDto mapToResponseDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
