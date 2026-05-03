package uz.hojiakbar.service;

import uz.hojiakbar.dto.request.PurchasesRequestDto;
import uz.hojiakbar.dto.response.PurchasesResponseDto;

public interface PurchasesService {
    PurchasesResponseDto createPurchase(PurchasesRequestDto requestDto);
}
