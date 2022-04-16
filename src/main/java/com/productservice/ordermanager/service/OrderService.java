package com.productservice.ordermanager.service;


import com.productservice.ordermanager.entity.Order;
import com.productservice.ordermanager.external.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

//    public List<Order> getOrdersOfUser(int id){
//        orderRepository.finAllByUserId(id);
//        return null;
//    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }


}
