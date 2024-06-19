package pl.rafzab.springdatajpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import pl.rafzab.springdatajpa.db.entities.Order;
import pl.rafzab.springdatajpa.db.repositories.OrderRepository;
import pl.rafzab.springdatajpa.projections.OrderDetails;
import pl.rafzab.springdatajpa.projections.OrderDetailsDTO;

import java.util.List;

@Service
public class SpringDataJpaService {

    @Autowired
    private OrderRepository orderRepository;

    public void test(){
        // PROBLEM  N+1

//        List<Order> orderList = orderRepository.findAll();
//        List<Order> orderList = orderRepository.findAllByQuery();
//        List<Order> orderList = orderRepository.findAllByQueryNative();


        System.out.println("\n NATIVE PROJECTION \n");
        List<OrderDetails> orderDetailsList = orderRepository.findAllByQueryNativeProjection();
        orderDetailsList.forEach(orderDetails -> System.out.println(orderDetails.getAmount()));

        System.out.println("\n QUERY PROJECTION \n");
        List<OrderDetailsDTO> orderDetailsDTOS = orderRepository.findAllByQueryProjection();
        orderDetailsDTOS.forEach(System.out::println);

        System.out.println("\n ENTITY GRAPH \n");
        List<Order> orderList1 = orderRepository.findAllByWithGraph();

    }

}
