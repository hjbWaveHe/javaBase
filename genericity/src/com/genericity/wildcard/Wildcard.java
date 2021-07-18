package com.genericity.wildcard;

/**
 * @Author hjb
 * @Date 18/7/2021 下午 2:41
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

import org.junit.Test;

import java.util.List;

/**
 * 通配符的使用 ?
 */
public class Wildcard {

    @Test
    public void useWildcard1(){

        List<String> sList = null;
        List<Object> oList = null;
        List<?> list = null;//List<?>作为List<String>和List<Object>的公共父类
        list = sList;
        list = oList;
        list.add(null);//不允许添加除null以外的值
        Object o1 = list.get(0);//允许读操作

    }

    @Test
    public void useWildcard2(){

        List<? extends Person> ePList = null;//<=
        List<? super Person> sSList = null;//>=

        List<Student> sList = null;
        List<Person> pList = null;
        List<Object> oList = null;

        ePList = sList;
        ePList = pList;
//        ePList = oList;//编译报错

//        sSList = sList;//编译报错
        sSList = pList;
        sSList = oList;

    }

}
