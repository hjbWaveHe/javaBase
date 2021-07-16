package com.object;

import org.junit.Test;

import java.io.*;

/**
 * @Author hjb
 * @Date 15/7/2021 下午 4:17
 * @Version 1.0
 * @Contact 1754729389@qq.com
 * @Description 对象流ObjectInputStream和ObjectOutputStream 用于存取基本数据类型数据或对象的处理流
 */
public class ObjectIO {

    @Test
    public void testOIO(){

        Person p1 = new Person("Betty", 23, '男');
        //序列化
        if(saveToFile(p1,"dir1/objectData2.dat")){
            System.out.println("Serialization completed.");
        }
        if( revertToObject("dir1/objectData2.dat") != null){
            Person p2 = (Person) revertToObject("dir1/objectData2.dat");
            System.out.println(p2.getName());
            System.out.println("The deserialization is complete.");
        }

    }



    /**
     * 序列化
     * 将java对象保存到磁盘中或通过网络传输出去
     */
    @Test
    public void useObjectOS(){
        ObjectOutputStream oos = null;

        try {
            //流的创建
            oos = new ObjectOutputStream(new FileOutputStream("dir1/objectData.dat"));

            //数据的存取
            oos.writeObject(new String("Ok!"));
            oos.flush();
            System.out.println("Data output completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    /**
     * 反序列化
     */
    @Test
    public void useObjectIS(){
        ObjectInputStream ois = null;

        try {
            //流的创建
            ois = new ObjectInputStream(new FileInputStream("dir1/objectData.dat"));

            //数据的存取
            Object o1 = ois.readObject();
            System.out.println(o1);
            System.out.println("Data read completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 将一个对象序列化并保存到一个文件中
     * @param o1 需序列化的对象
     * @param destPath 存放的文件位置
     * @return 返回false表示序列化失败
     */
    public boolean saveToFile(Object o1,String destPath){
        ObjectOutputStream oos = null;
        boolean isCompleted = false;

        try {
            //流的创建
            oos = new ObjectOutputStream(new FileOutputStream(destPath));

            //数据的存取
            oos.writeObject(o1);
            oos.flush();
            isCompleted = true;
            System.out.println("Data output completed.");
            return isCompleted;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isCompleted;
        }
    }

    /**
     *从文件中读取数据并还原为java对象
     * @param srcPath 目标文件
     * @return 返回null表示读取失败
     */
    public Object revertToObject(String srcPath){

        ObjectInputStream ois = null;
        Object o1 = null;

        try {
            //流的创建
            ois = new ObjectInputStream(new FileInputStream(srcPath));

            //数据的存取
            o1 = ois.readObject();
            return o1;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return o1;
        }

    }

}
