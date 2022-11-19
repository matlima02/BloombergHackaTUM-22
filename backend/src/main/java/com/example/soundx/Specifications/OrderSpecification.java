package com.example.soundx.Specifications;



import com.example.soundx.model.Customer;
import com.example.soundx.model.Order;
import com.example.soundx.model.Order_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.persistence.criteria.*;

public interface OrderSpecification {

    public static Specification<Order> isMatchingOrder(Order order) {
        return new Specification<Order>() {
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                ExpressionParser parser = new SpelExpressionParser();
                return builder.and((Expression<Boolean>) parser.parseExpression("root.get(Order_.amount)==order.getAmount()"), (Expression<Boolean>) parser.parseExpression("root.get(Order_.price)>=order.getPrice()"));
            }
        };
    }
}
