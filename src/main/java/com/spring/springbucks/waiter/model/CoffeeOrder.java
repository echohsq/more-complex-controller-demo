package com.spring.springbucks.waiter.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author hao
 * @create 2020-01-16 22:43
 */
@Entity
@Table(name = "T_ORDER")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeOrder extends BaseEntity implements Serializable {
    private String customer;
    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;
    @Enumerated
    @Column(nullable = false)
    private OrderState state;
}
