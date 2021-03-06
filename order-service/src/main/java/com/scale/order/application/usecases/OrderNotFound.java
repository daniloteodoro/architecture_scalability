package com.scale.order.application.usecases;

import com.scale.domain.DomainError;
import com.scale.domain.Order;

public class OrderNotFound extends DomainError {
    public OrderNotFound(Order.OrderId id) {
        super(String.format("Order %s was not found", id));
    }

    public OrderNotFound(String message) {
        super(message);
    }
}
