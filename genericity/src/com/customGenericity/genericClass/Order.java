package com.customGenericity.genericClass;

/**
 * @Author hjb
 * @Date 16/7/2021 下午 5:23
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

/**
 * 自定义泛型类
 * 静态方法不能使用类的泛型参数，实例化时泛型参数需要明确，但却不明确。
 * @param <T>
 * @param <V>
 */
public class Order<T,V> {

    private String name;
    private Integer id;
    private T orderT;

    public Order() {
    }

    public Order(String name, Integer id, T orderT) {
        this.name = name;
        this.id = id;
        this.orderT = orderT;
    }

    public Order(String name, T orderT) {
        this.name = name;
        this.orderT = orderT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", orderT=" + orderT +
                '}';
    }
}
