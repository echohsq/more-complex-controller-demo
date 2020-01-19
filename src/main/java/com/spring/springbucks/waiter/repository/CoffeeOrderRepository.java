package com.spring.springbucks.waiter.repository;

import com.spring.springbucks.waiter.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hsqzs
 * date 2020/1/19 9:25
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
