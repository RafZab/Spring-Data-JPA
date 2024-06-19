package pl.rafzab.springdatajpa.db.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String paymentMethod;

    @OneToOne(mappedBy = "payment", fetch = FetchType.EAGER)
    private Order order;
}