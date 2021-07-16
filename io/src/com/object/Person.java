package com.object;

import java.io.Serializable;

/**
 * @Author hjb
 * @Date 15/7/2021 下午 4:53
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

/**
 * 序列化条件
 * 1.实现接口serializable
 * 2.提供一个全局常量serialVersionUID
 * 3.内部属性可序列化。被static和transient修饰的内部成员不可序列化
 */
public class Person implements Serializable {

    //不显示赋值，java运行时环境根据类的内部环境自动生成，当类的实例变量发生变化时，UID会随之改变。
    public static final long serialVersionUID = 421234131L;//标识

    private String name;
    private int age;
    private char sex;

    public Person() {
    }

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
