package com.example.soundx.Specifications;

import com.example.soundx.model.Order;
import com.example.soundx.model.Order_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.persistence.criteria.*;


public class OrderSpecification implements Specification<Order>{
    private final Order criteria;

    public OrderSpecification(Order criteria) {
        this.criteria=criteria;
    }
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                ExpressionParser parser = new SpelExpressionParser();
                //root=query.from(Order.class);
                //query.select(root).where(builder.equal(root.get("price"),criteria.getPrice()));
                Predicate firstPredicate;
                Predicate secondPredicate;
                Predicate thirdPredicate;
                /*Path<Integer> amountOrder = root.<Integer>get("amount");
                Path<Double> priceOrder = root.<Double>get("price");
                Path<String> typeOrder = root.<String>get("type");*/
                if(criteria.getType().equals("BUY")) {
                    firstPredicate = builder.greaterThanOrEqualTo(root.<Integer>get(Order_.amount),criteria.getAmount());
                    secondPredicate = builder.lessThanOrEqualTo(root.<Double>get(Order_.price),criteria.getPrice());
                    thirdPredicate = builder.equal(root.<String>get(Order_.type),"SELL");
                    /*firstPredicate = builder.greaterThanOrEqualTo(amountOrder,criteria.getAmount());
                    secondPredicate = builder.lessThanOrEqualTo(priceOrder,criteria.getPrice());
                    thirdPredicate = builder.equal(typeOrder,"SELL");*/
                }
                else {
                    firstPredicate = builder.lessThanOrEqualTo(root.get(Order_.amount),criteria.getAmount());
                    secondPredicate = builder.greaterThanOrEqualTo(root.get(Order_.price),criteria.getPrice());
                    thirdPredicate = builder.equal(root.get(Order_.type),"BUY");
                }

                return builder.and(firstPredicate,secondPredicate,thirdPredicate);
            }
        }
