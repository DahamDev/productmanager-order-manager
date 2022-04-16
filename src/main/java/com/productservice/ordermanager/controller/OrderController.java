package com.productservice.ordermanager.controller;

import com.productservice.ordermanager.entity.Order;
import com.productservice.ordermanager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    //create an order-write to kafka
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.ok().body("done");
    }
    //cancel order - write to kafka

    //get all orders
    @GetMapping("/get")
    public ResponseEntity getOrders(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    //get orders for a perticular user
    @GetMapping("/get/{id}")
    public ResponseEntity getOrdersForUser(@PathVariable int id){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

}
