package com.spring.springbucks.waiter.model;

/**
 * @author hao
 * @create 2020-01-16 22:43
 */
public enum OrderState {
    /**
     *INIT（订单初初始）, PAID（支付订单）, BREWING（订单制做）,
     * BREWED（订单完成）, TAKEN（交易完成）, CANCELLED（取消）
     */
    INIT("初始订单"),PAID("支付订单"),
    BREWING("订单制做"),BREWED("订单完成"),TAKEN("交易完成"),CANCELLED("取消订单");

    private final String zh;
    OrderState(String zh) {
        this.zh = zh;
    }
    public String getName() {
        return zh;
    }
}
