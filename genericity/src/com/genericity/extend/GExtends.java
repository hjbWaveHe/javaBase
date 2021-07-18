package com.genericity.extend;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hjb
 * @Date 16/7/2021 下午 6:19
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

/**
 * 泛型在继承时的体现
 */
public class GExtends {

    /**
     * 类A是类B的父类，G<A> 和G<B> 不具备子父类关系，是并列关系。
     */
    @Test
    public void extendsTest1(){

        Object o1 = null;
        String str1 = null;
        o1 = str1;

        Object[] oArr1 = null;
        String[] sArr1 = null;
        oArr1 = sArr1;

        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;//list1 和 list2 不具备子父类关系，编译报错

        
    }

    /**
     * 类A是类B的父类，则A<G>是B<G>的父类
     */
    @Test
    public void extendsTest2(){

        List<String> list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;

    }

}
