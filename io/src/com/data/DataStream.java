package com.data;

import org.junit.Test;

import java.io.*;

/**
 * @Author hjb
 * @Date 15/7/2021 下午 3:47
 * @Version 1.0
 * @Contact 1754729389@qq.com
 * @Description 数据流DataInputStream和DataOutputStream
 */
public class DataStream {

    @Test
    public void useDataOS(){
        DataOutputStream dos =
                null;

        try {
            //流的创建
            dos = new DataOutputStream(new FileOutputStream("dir1/hello5.txt"));

            //数据存取
            String str = new String("wow");
            dos.writeUTF(str);
            dos.flush();
            dos.writeInt(1);
            dos.flush();
            dos.writeDouble(12.30);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
            System.out.println("Data transfer completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void useDataIS(){
        DataInputStream dis = null;

        try {
            //流的创建
            dis = new DataInputStream(new FileInputStream("dir1/hello5.txt"));

            //数据的存取
            //读取的顺序要与写入时的顺序一致
            String str = dis.readUTF();
            System.out.println("Reads a string : " + str);
            int i1 = dis.readInt();
            System.out.println("Reads a integer :" + i1);
            boolean b1 = dis.readBoolean();
            System.out.println("Reads a boolean : " + b1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
