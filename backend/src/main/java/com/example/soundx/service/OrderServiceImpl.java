package com.example.soundx.service;

import com.example.soundx.Specifications.OrderSpecification;
import com.example.soundx.model.Customer;
import com.example.soundx.model.Match;
import com.example.soundx.model.Order;
import com.example.soundx.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
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
