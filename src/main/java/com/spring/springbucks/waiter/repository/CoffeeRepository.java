package com.spring.springbucks.waiter.repository;

import com.spring.springbucks.waiter.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hsqzs
 * date 2020/1/19 9:24
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee findByName(String name);
    List<Coffee> findByNameInOrderById(List<String> names);
}
