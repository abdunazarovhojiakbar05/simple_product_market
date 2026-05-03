package uz.hojiakbar.mapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uz.hojiakbar.dto.response.ProductResponseDto;
import uz.hojiakbar.model.Product;

public class ProductMapper {


    public static ResponseEntity<ProductResponseDto> toResponseDto(Product product) {

        if (product == null) return null;


        return  new ResponseEntity<>(new ProductResponseDto(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()), HttpStatus.OK);
    }
}
