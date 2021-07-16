package com.randomAccess;

/**
 * @Author hjb
 * @Date 16/7/2021 上午 7:26
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * RandomAccessFile直接继承于java.lang.object类，实现类DataInput和DataOutput两个接口
 * RandomAccessFile既可以作为输入流又可以作为输出流
 * RandomAccessFile作为输出流，当文件不存在时会自动创建；文件存在时覆盖写入
 *
 */
public class AccessFile {

    @Test
    public void useRandomAccessFile1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;

        try {
            //流的创建
            /**创建 RandomAccessFile 类实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式：
             *r: 以只读方式打开
             *rw：打开以便读取和写入
             *rwd:打开以便读取和写入；同步文件内容的更新
             *rws:打开以便读取和写入；同步文件内容和元数据的更新
             */
            raf1 = new RandomAccessFile("dir1/hello.txt","r");
            raf2 = new RandomAccessFile("dir1/hello6.txt","rw");

            //数据的存取
            byte[] b= new byte[1024];
            int len;
            while((len = raf1.read(b)) != -1){
                raf2.write(b,0,len);
            }
            System.out.println("Data transfer completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 使用RandomAccessFile实现插入效果
     */
    @Test
    public void useRandomAccessFile2(){
        RandomAccessFile raf = null;

        try {
            //流的创建
            raf = new RandomAccessFile("dir1/hello6.txt","rw");

            //数据的存取
            StringBuffer sb = new StringBuffer((int) (new File("dir1/hello6.txt").length()));
            int len;
            byte[] b = new byte[1024];
            raf.seek(3);//将指针设置为3，对文件的读取在该位置往后进行
            while((len = raf.read(b)) != -1){
                sb.append(new String(b,0,len));
            }
            raf.seek(3);//经过循环后指针为文件末尾，需将指针设置为3开始插入操作
            raf.write("wow".getBytes());
            raf.write(sb.toString().getBytes());
            System.out.println("Data output completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
