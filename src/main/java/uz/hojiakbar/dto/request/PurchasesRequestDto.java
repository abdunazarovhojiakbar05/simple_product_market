package uz.hojiakbar.dto.request;


import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  PurchasesRequestDto {

    @Positive(message = "foydalanuvchi id musbat bo'lishi kerak")
    Long userId;

    @Positive(message = "tovar id musbat bo'lishi kerak")
    Long productId;

}
