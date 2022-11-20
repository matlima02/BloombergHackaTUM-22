package com.example.soundx.controller;


import com.example.soundx.model.Match;
import com.example.soundx.model.Order;
import com.example.soundx.service.MatchService;
import com.example.soundx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private MatchService matchService;

    @PostMapping("/add")
    public String add(@RequestBody Order order) {
        orderService.saveOrder(order);
        return "New order is added!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int orderId) {
        orderService.deleteOrder(orderId);
        return "Order was deleted!";
    }

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping("/matchOrders/{id}")
    public String findMatchForOrder(@PathVariable(value = "id") int orderId) {

        Order order = orderService.getAllOrders().stream().filter(o -> o.getId()==orderId).findFirst().get();
        Order o = orderService.findMatchForOrder(order);
        if(o==null) {
            return "No match found for requested order!";
        }
        else {
            Match match = new Match();
            if(o.getType().equals("SELL")) {
                match.setMatchArtistId(o.getArtistId());
                match.setMatchCustomerId(order.getCustomerId());
                match.setMatchedPrice(o.getPrice());
                match.setMatchedAmount(o.getAmount());
            }
            else {
                match.setMatchArtistId(order.getArtistId());
                match.setMatchCustomerId(o.getCustomerId());
                match.setMatchedPrice(order.getPrice());
                match.setMatchedAmount(order.getAmount());
            }


            matchService.saveMatch(match);
            StringBuilder bldr = new StringBuilder();
            bldr.append("Found matching "+o.getType()+" order for requested "+order.getType()+"order type!\n");
            bldr.append("Match was added to OrderHistory!\n");
            bldr.append("CONFIRMED TRANSACTION! DELETING ORDERS!");
            //Delete the matching orders
            delete(o.getId());
            delete(order.getId());
            return bldr.toString();
        }
    }
}
