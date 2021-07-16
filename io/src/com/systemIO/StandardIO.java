package com.systemIO;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * @Author hjb
 * @Date 15/7/2021 下午 2:57
 * @Version 1.0
 * @Contact 1754729389@qq.com
 * @Description 标准输入输出System.in System.out
 */
public class StandardIO {

    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            //流的创建
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            //数据的存取
            String data;
            while(true){
                System.out.print("Please enter a string:");
                data = br.readLine();
                if("e".equalsIgnoreCase(data)|| "exit".equalsIgnoreCase(data)){
                    System.out.println("The program is over.");
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 注意：idea单元测试不支持键盘输入 main方法支持
     * System.in 输入流 默认从键盘输入
     * System.out 打印流 默认从控制台输出
     * System类的setIn(InputStream is)/setOut(PrintStream ps)可以设置输入、输出的流
     */
    @Test
    public void useSystemIn(){
        BufferedReader br = null;

        try {
            //流的创建
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            //数据的存取
            String data;
            while(true){
                System.out.print("Please enter a string:");
                data = br.readLine();
                if("e".equalsIgnoreCase(data)|| "exit".equalsIgnoreCase(data)){
                    System.out.println("The program is over.");
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    public void useSystemOut(){



    }

}
