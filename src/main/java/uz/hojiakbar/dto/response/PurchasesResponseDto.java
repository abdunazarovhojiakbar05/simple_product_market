package uz.hojiakbar.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchasesResponseDto {

     Long id;
     Long userId;
     Long productId;
     Double price;
     java.time.LocalDateTime purchaseDate;
}

