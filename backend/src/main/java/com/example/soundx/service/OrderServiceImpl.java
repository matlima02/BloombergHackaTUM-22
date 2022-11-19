package src.main.java.com.example.soundx.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.com.example.soundx.Specifications.OrderSpecification;
import src.main.java.com.example.soundx.model.Order;
import src.main.java.com.example.soundx.repository.OrderRepository;


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
        List<Order> l = orderRepository.findAll(OrderSpecification.isMatchingOrder(order));
        if(l.size()>1) {
            return l.stream().reduce((a, b)->a.getPrice()<b.getPrice() ? a:b).get();
        } else if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }
}
