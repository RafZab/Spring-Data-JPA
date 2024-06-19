package pl.rafzab.springdatajpa.projections;

import lombok.ToString;

import java.sql.Date;

public interface OrderDetails {

    Long getOrderId();

    Date getOrderDate();

    String getCustomerName();

    Double getAmount();
}
