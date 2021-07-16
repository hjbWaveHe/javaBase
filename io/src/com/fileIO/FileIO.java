package com.fileIO;

import org.junit.Test;

import javax.annotation.processing.Filer;
import java.io.*;
import java.lang.reflect.ParameterizedType;

/**
 * @Author hjb
 * @Date 10/7/2021 下午 6:34
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */
public class FileIO {

    public static void main(String[] args) {
        FileIO fio = new FileIO();
        String srcPathname = "io/image/1.jpg";
        String destPathname = "io/image/3.jpg";
        fio.copyNontextFile(srcPathname,destPathname);

    }

    @Test
    public void useFileReader1(){

        FileReader fileReader = null;

        try {
            //实例化File 指明需要操作的文件
            File file1 = new File("dir1/hello.txt");
            System.out.println(file1.getAbsolutePath());

            //流的实例化
            fileReader = new FileReader(file1);

            //数据的读入
            int read = fileReader.read();//返回读入的一个字符(int形式表示的字符)，返回-1表示数据已经达到文件末尾
            while(read != -1){
                System.out.print((char)read);
                read = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * read()的重载方法
     */
    @Test
    public void useFileReader2(){

        FileReader fileReader = null;

        try {
            //实例化File
            File file1 = new File("dir1/hello.txt");

            //流的创建
            fileReader = new FileReader(file1);

            //数据的读取
            //int read(char[] cbuf) 返回每次读取的字符个数，返回-1表示已到文件末尾
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                System.out.print(new String(cbuf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * FileWriter(File file,boolean bool) bool默认为false
     * 如果bool为false表示对文件进行覆盖写入
     * 如果bool为true表示对文件进行追加写入
     * write() 对文件进行写入
     * 如果目标文件不存在则会自动创建文件后写入
     */
    @Test
    public void useFileWriter1(){
        FileWriter fileWriter = null;

        try {
            //实例化File
            File file1 = new File("dir1/hello2.txt");

            //流的创建
            fileWriter = new FileWriter(file1);

            //数据的存储
            fileWriter.write("Good evening!\n");
            fileWriter.write("Good night!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 对文本文件的复制
     */
    @Test
    public void useFileIO1(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            //实例化File 指明读取的文件和存储的目标位置
            File file1 = new File("dir1/hello.txt");
            File file2 = new File("dir2/hello.txt");

            //流的创建
            fileReader = new FileReader(file1);
            fileWriter = new FileWriter(file2,true);

            //数据的存取
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf,0,len);
            }
            System.out.println("Data transfer completed!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭操作
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void useFileInputStream(){
        FileInputStream fileInputStream = null;

        try {
            //实例化File 指明要操作的文件
            File file1 = new File("dir1/hello.txt");
            File file2 = new File("image/1.jpg");

            //流的创建
            fileInputStream = new FileInputStream(file1);

            //数据的读取
            //使用字节流处理文本文件是可能会出现乱码的
            byte[] bytes = new byte[5];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                String str = new String(bytes,0,len);
                System.out.print(str);
            }
            System.out.println("\n");
            System.out.println("Data read complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 对非文本文件的复制
     */
    @Test
    public void useFileInOutStream(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //实例化File 指明需操作文件和目标位置
            File file1 = new File("image/1.jpg");
            File file2 = new File("image/2.jpg");

            //流的创建
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            //数据的存取
            byte[] bytes = new byte[5];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的的关闭
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    /**
     * 实现对非文本文件的复制
     * @param srcPathname 源文件的位置
     * @param destPathname 需复制到的目标位置
     */
    public void copyNontextFile(String srcPathname,String destPathname){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPathname);
            File destFile = new File(destPathname);

            //流的创建
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //数据的存取
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭操作
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 实现对文本文件的复制
     * @param srcPathname 源文件的位置
     * @param destPathname 需复制到的目标位置
     */
    public void copyTextFile(String srcPathname,String destPathname){

        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File(srcPathname);
            File destFile = new File(destPathname);

            //流的创建
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //数据的存取
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }
            System.out.println("Data transfer complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
