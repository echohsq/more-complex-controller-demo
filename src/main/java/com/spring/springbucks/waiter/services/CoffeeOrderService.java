package com.spring.springbucks.waiter.services;

import com.spring.springbucks.waiter.model.Coffee;
import com.spring.springbucks.waiter.model.CoffeeOrder;
import com.spring.springbucks.waiter.model.OrderState;
import com.spring.springbucks.waiter.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hsqzs
 * date 2020/1/19 10:18
 */
@Service
@Transactional
@Slf4j
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;
    public CoffeeOrder createOrder(String customer, Coffee...coffees) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .build();
        CoffeeOrder saved = coffeeOrderRepository.save(order);
        log.info("new order {}", saved);
        return saved;
    }
    public CoffeeOrder get(Long id) {
        return coffeeOrderRepository.getOne(id);
    }
    public boolean setOrderState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        coffeeOrderRepository.save(order);
        log.info("update order {}", order);
        return true;
    }
}
