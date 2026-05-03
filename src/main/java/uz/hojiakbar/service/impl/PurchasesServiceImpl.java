package uz.hojiakbar.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hojiakbar.repository.ProductRepository;
import uz.hojiakbar.repository.PurchasesRepository;
import uz.hojiakbar.repository.UserRepository;
import uz.hojiakbar.dto.request.PurchasesRequestDto;
import uz.hojiakbar.dto.response.PurchasesResponseDto;
import uz.hojiakbar.model.Product;
import uz.hojiakbar.model.Purchase;
import uz.hojiakbar.model.User;
import uz.hojiakbar.service.ProductService;
import uz.hojiakbar.service.PurchasesService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PurchasesServiceImpl implements PurchasesService {


    private final ProductService productService;
    private final ProductRepository productRepository;

    private final PurchasesRepository purchasesRepository;
    private final UserRepository userRepository;

    /**
     * @param requestDto
     * @return
     */
    @Override
    public PurchasesResponseDto createPurchase(PurchasesRequestDto requestDto) {



        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));


        Product product  = productRepository.findById(requestDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));


             if(product.getQuantity() <= 0){
                 throw new RuntimeException("Product is out of stock");
             }

             product.setQuantity(product.getQuantity() - 1);
             productService.updateProduct(product);

             Purchase purchases = new Purchase();
             purchases.setProduct(product);
             purchases.setUser(user);
             purchases.setPrice(product.getPrice());
             purchases.setPurchaseDate(LocalDateTime.now());
             purchasesRepository.save(purchases);

           return new PurchasesResponseDto(
                   purchases.getId(),
                   purchases.getProduct().getId(),
                   purchases.getUser().getId(),
                   purchases.getPrice(),
                   purchases.getPurchaseDate());
    }
}
