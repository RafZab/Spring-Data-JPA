package pl.rafzab.springdatajpa.projections;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDetailsDTO {

    public OrderDetailsDTO(Long orderId, Date orderDate, String customerName, Double amount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.amount = amount;
    }

    private Long orderId;

    private Date orderDate;

    private String customerName;

    private Double amount;
}
