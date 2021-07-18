package com.genericity;

/**
 * @Author hjb
 * @Date 16/7/2021 下午 4:48
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

import org.junit.Test;

import java.util.*;

/**
 * 泛型
 * jdk5.0新增的特性
 */
public class Genericity {

    /**
     * List使用泛型
     */
    @Test
    public void useGenericity1(){

        ArrayList<Integer> arr1 = new ArrayList<>();

        arr1.add(19);

        System.out.println(arr1);

        Integer i1 = arr1.get(0);
        System.out.println(i1);

    }

    /**
     * map使用泛型
     */
    @Test
    public void useGenericity2(){

        Map<String,Integer> m1 = new HashMap<>();
        m1.put("age",23);
        m1.put("sex",1);
        m1.put("height",80);

        Set<Map.Entry<String, Integer>> e1 = m1.entrySet();
        Iterator<Map.Entry<String, Integer>> iter1 = e1.iterator();
        while(iter1.hasNext()){
            Map.Entry<String, Integer> en1 = iter1.next();
            System.out.println(en1.getKey() + " = " + en1.getValue());
        }

    }

}
