package com.customGenericity.genericClass;

import org.junit.Test;

/**
 * @Author hjb
 * @Date 16/7/2021 下午 5:28
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */
public class GenericityTest {

    @Test
    public void useCustomG1(){

        Order<String, Integer> o1 = new Order<>();


    }

    @Test
    public void useCustomG2(){

        SubOrder<String, Integer> so1 = new SubOrder<>();

    }

    @Test
    public void useCustomG3(){

        SubOrder2 so1 = new SubOrder2();

    }

    @Test
    public void useCustomG4(){

        SubOrder3<Integer> so1 = new SubOrder3<>();


    }


    @Test
    public void useCustomG5(){



    }

}
