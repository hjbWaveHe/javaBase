package com.fileIO;

import org.junit.Test;

import javax.swing.*;
import java.io.*;

/**
 * @Author hjb
 * @Date 11/7/2021 下午 4:23
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */
public class FileBufferedIO {

    public static void main(String[] args) {

        FileBufferedIO fio = new FileBufferedIO();
        String srcPath = "io/image/1.jpg";
        String destPath = "io/image/4.jpg";
        fio.copyNontextFile(srcPath,destPath);

    }


    @Test
    public void useBufferedStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //实例化File 指明需要操作的文件
            File srcFile = new File("image/1.jpg");
            File destFile = new File("image/4.jpg");

            //节点流的创建
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //缓冲流的创建
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //数据的存取
            byte[] bytes = new byte[1024];
            int len;
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            //先关闭外层的流，内层的流会自动关闭
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Test
    public void useBufferedRW1(){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("dir1/hello.txt");
            File destFile = new File("dir2/hello2.txt");

            //流的创建
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //数据的存取
            char[] cbuf = new char[5];
            int len;
            while((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
     * String readLine()方法 每次读取一行，返回null表示到文件末尾
     * 返回的数据不包含换行符
     */
    @Test
    public void useBufferedRW2(){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //流的创建
            br = new BufferedReader(new FileReader(new File("dir1/hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dir2/hello3.txt")));

            //数据的存取
            String data;
            while((data = br.readLine()) != null){
                bw.write(data);//不包含\n
                bw.newLine();//加换行符
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
     * 实现对文本文件的复制操作
     * @param srcParh 源文件的位置
     * @param destPath 需复制到的目标位置
     */
    public void copyTextFile(String srcParh,String destPath){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File(srcParh);
            File destFile = new File(destPath);

            //流的创建
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //数据的存取
            char[] cbuf = new char[5];
            int len;
            while((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
     * 实现对非文本文件的复制操作
     * @param srcPath 源文件的位置
     * @param destPath 需复制到的目标位置
     */
    public void copyNontextFile(String srcPath,String destPath){

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //流的创建
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //数据的存取
            byte[] bytes = new byte[1024];
            int len;
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void useTransformStreamReader(){

        InputStreamReader isr = null;//使用系统默认的字符集
        InputStreamReader isr2 = null;

        try {
            //实例化File 指明操作的文件
            File srcFile = new File("dir1/hello.txt");

            //流的创建
            FileInputStream fis = new FileInputStream(srcFile);
            isr = new InputStreamReader(fis);
            //第二个参数取决于操作文件保存所所使用的字符集
            isr2 = new InputStreamReader(fis,"UTF-8");

            //数据的存取
            char[] cbuf = new char[5];
            int len;
            while((len = isr2.read(cbuf)) != -1){

                String str = new String(cbuf,0,len);
                System.out.print(str);

            }
            System.out.println();
            System.out.println("Data read complete.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr2 != null){
                try {
                    isr2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void useTransformStream(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            //实例化File 指明操作的文件
            File srcFile = new File("dir1/hello.txt");
            File destFile = new File("dir1/hello4.txt");

            //流的创建
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos,"UTF-8");

            //数据的存取
            char[] cbuf = new char[5];
            int len;
            while((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
            System.out.println("Data transfer completed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
