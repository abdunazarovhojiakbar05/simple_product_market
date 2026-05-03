package uz.hojiakbar.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.hojiakbar.dto.request.PurchasesRequestDto;
import uz.hojiakbar.dto.response.PurchasesResponseDto;
import uz.hojiakbar.service.PurchasesService;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
public class PurchasesController {

    private final PurchasesService purchasesService;


    @PostMapping
    public ResponseEntity<PurchasesResponseDto> createPurchase(@Valid @RequestBody PurchasesRequestDto requestDto) {
        PurchasesResponseDto responseDto = purchasesService.createPurchase(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
