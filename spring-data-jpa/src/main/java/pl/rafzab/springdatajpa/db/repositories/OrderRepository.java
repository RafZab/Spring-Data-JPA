package pl.rafzab.springdatajpa.db.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rafzab.springdatajpa.db.entities.Order;
import pl.rafzab.springdatajpa.projections.OrderDetails;
import pl.rafzab.springdatajpa.projections.OrderDetailsDTO;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o")
    List<Order> findAllByQuery();

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Order> findAllByQueryNative();

    @Query(value = "SELECT o.id AS orderId, " +
            "o.order_date AS orderDate, " +
            "c.name AS customerName, " +
            "p.amount AS amount " +
            "FROM orders AS o " +
            "INNER JOIN clients c ON o.client_id = c.id " +
            "INNER JOIN payments p ON o.payment_id = p.id", nativeQuery = true)
    List<OrderDetails> findAllByQueryNativeProjection();

    @Query("SELECT new pl.rafzab.springdatajpa.projections.OrderDetailsDTO(o.id, " +
            "o.orderDate, " +
            "o.client.name, " +
            "o.payment.amount) " +
            "FROM Order o")
    List<OrderDetailsDTO> findAllByQueryProjection();

    @EntityGraph(value = Order.WITH_ALL, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT o FROM Order o")
    List<Order> findAllByWithGraph();
}