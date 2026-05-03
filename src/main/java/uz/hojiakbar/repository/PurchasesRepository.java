package uz.hojiakbar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.hojiakbar.model.Purchase;

import java.util.List;

public interface PurchasesRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByUserId(Long userId);
}
