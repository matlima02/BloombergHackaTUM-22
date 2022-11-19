package src.main.java.com.example.soundx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.example.soundx.model.Order;
import src.main.java.com.example.soundx.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public String add(@RequestBody Order order){
        orderService.saveOrder(order);
        return "New custoer is added!";
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
