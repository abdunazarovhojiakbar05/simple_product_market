package uz.hojiakbar.service;

import org.springframework.http.ResponseEntity;
import uz.hojiakbar.dto.request.ProductRequestDto;
import uz.hojiakbar.dto.response.ProductResponseDto;


public interface AdminService {


    ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto dto );

    ResponseEntity<ProductResponseDto> addProduct(  Long quantity, Long id);


}
