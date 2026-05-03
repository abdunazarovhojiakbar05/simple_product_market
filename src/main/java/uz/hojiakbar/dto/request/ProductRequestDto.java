package uz.hojiakbar.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {

     @NotBlank(message = "nom bosh bolishi mukin emas")
     String name;

     @NotBlank(message = "tavsif bosh bolishi mukin emas")
     String description;

     @Positive(message = "narx musbat bo'lishi kerak")
     double price;

     @Positive(message = "miqdor musbat bo'lishi kerak")
     Long quantity;
}
