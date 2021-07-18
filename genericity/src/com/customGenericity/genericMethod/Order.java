package com.customGenericity.genericMethod;

/**
 * @Author hjb
 * @Date 16/7/2021 下午 5:23
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型方法
 * 与类的泛型参数无关
 * 可以声明为静态方法，泛型参数在被调用时才被确定
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

    /**
     * 泛型方法，将E类型行的数组赋值到List中并返回
     * @param e E类型的数组
     * @param <E> 指明E是一个泛型
     * @return 返回一个List集合
     */
    public <E> List<E> copyArrayToList(E[] e){

        ArrayList<E> es = new ArrayList<>();
        for(E en : e){
            es.add(en);
        }
        return es;

    }

}
