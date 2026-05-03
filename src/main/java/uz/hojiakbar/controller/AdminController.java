package uz.hojiakbar.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hojiakbar.dto.request.ProductRequestDto;
import uz.hojiakbar.dto.response.ProductResponseDto;
import uz.hojiakbar.dto.response.UserResponseDto;
import uz.hojiakbar.model.User;
import uz.hojiakbar.service.AdminService;
import uz.hojiakbar.service.ProductService;
import uz.hojiakbar.service.UserService;

import java.util.List;


@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final ProductService productService;


    @GetMapping("/all/users")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/all/products")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/new")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto dto) {
        return adminService.createProduct(dto );
    }


    @PostMapping("/add/{id}")
    public ResponseEntity<ProductResponseDto> addProduct( @Valid @RequestParam Long quantity, @PathVariable Long id) {
        return adminService.addProduct( quantity, id);
    }


}
