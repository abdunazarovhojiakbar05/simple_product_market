package uz.hojiakbar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases") // todo s keremas
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private Double price;

    private LocalDateTime purchaseDate;
}
