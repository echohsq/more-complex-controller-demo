package com.spring.springbucks.waiter.services;

import com.spring.springbucks.waiter.model.Coffee;
import com.spring.springbucks.waiter.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hsqzs
 * date 2020/1/19 10:18
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "coffeeCache")
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;
    public Coffee saveCoffee(String name, Money money) {
        return coffeeRepository.save(Coffee.builder().name(name).price(money).build());
    }
    @Cacheable
    /**
     * 获取所有coffee信息
     */
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll(Sort.by("id"));
    }

    /**
     * 由id查找记录
     * @param id 主键id
     * @return coffee 名字，价格
     */
    public Coffee getCoffee(Long id) {
        return coffeeRepository.getOne(id);
    }
    public Coffee getCoffee(String name) {
        return  coffeeRepository.findByName(name);
    }
    public List<Coffee> getCoffeeByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }
}
