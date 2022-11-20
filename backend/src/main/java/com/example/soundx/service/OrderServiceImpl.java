package com.example.soundx.service;



import com.example.soundx.Specifications.OrderSpecification;
import com.example.soundx.model.Order;
import com.example.soundx.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }



    @Override
    public Order findMatchForOrder(Order order) {
        Specification<Order> o = new OrderSpecification(order);
        List<Order> l = orderRepository.findAll(o);
        if(l.size()>1) {
            //Get best offer for buyer/seller
            if(order.getType().equals("SELL")) {
                return l.stream().reduce((a, b)->a.getPrice()>b.getPrice() ? a:b).get();
            }
            else {
                return l.stream().reduce((a, b)->a.getPrice()<b.getPrice() ? a:b).get();
            }

        } else if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    @Override
    public void deleteOrder(int id) {
        Order o = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(o);
        return ;
    }
}
