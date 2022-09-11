package org.example.tacos.dao;

import org.example.tacos.entity.Order;

public interface OrderRepository {

    Order save(Order order);
}
