package pl.rafzab.springdatajpa.db.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @Column(nullable = false)
    private Date orderDate;
}