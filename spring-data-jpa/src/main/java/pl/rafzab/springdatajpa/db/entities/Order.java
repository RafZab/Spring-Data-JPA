package pl.rafzab.springdatajpa.db.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@NamedEntityGraph(
        name = Order.WITH_ALL,
        attributeNodes = {
                @NamedAttributeNode(value = "client", subgraph = "client.withAll"),
                @NamedAttributeNode(value = "payment")

        },
        subgraphs = {
                @NamedSubgraph(
                        name = "client.withAll",
                        attributeNodes = {
//                                @NamedAttributeNode("contact"),
                                @NamedAttributeNode("address")
                        }
                )
        }
)
@Data
@Entity
@Table(name = "orders")
public class Order {
    public static final String WITH_ALL = "order.withAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

//    @ManyToOne(fetch = FetchType.LAZY)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @Column(nullable = false)
    private Date orderDate;
}