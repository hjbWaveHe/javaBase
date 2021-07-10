package com.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author hjb
 * @Date 10/7/2021 下午 3:55
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */
public class UseFile {

    /**
     * File的实例化1
     */
    @Test
    public void fileInstantiate1(){

        //构造器1file(String pathname)

        //Test的方法中路径相对于当前Module
        //Main方法中路径相对于当前工程
        /**
         * 分隔符
         * windows：\\
         * unix: /
         */
        //共通的分隔符File.separator"
        File file1 = new File("txt/hello.txt");
        File file2 = new File(File.separator + "txt" + File.separator + "hello2.txt");

    }

    /**
     * File的实例化2
     */
    @Test
    public void fileInstantiate2(){

        //构造器2 file(String pathname1,String pathname2)
        File file1 = new File("txt","hello.txt");


    }

    /**
     * File的实例化3
     */
    @Test
    public void fileInstantiate3(){

        //构造器3 file(File fileName,String pathname)
        File file1 = new File("txt");
        File file2 = new File(file1,"hello.txt");


    }

    @Test
    public void useMethod1(){

        //实例化File
        File file1 = new File("txt/hello.txt");
        File file2 = new File("txt");

        //方法String getAbsolutePath() 获取绝对路径
        System.out.print("获取文件的绝对路径：");
        System.out.println(file1.getAbsolutePath());

        //方法String getPath() 获取路径
        System.out.print("获取路径：");
        System.out.println(file1.getPath());

        //方法String getName()  获取名称
        System.out.print("获取文件名称：");
        System.out.println(file1.getName());

        //方法String getParent() 获取上层文件目录路径。若无，返回null
        System.out.print("获取上层文件目录路径：");
        System.out.println(file1.getParent());

        //方法long length() 获取文件长度（即：字节数）。不能获取目录的长度。
        System.out.print("获取文件长度：");
        System.out.println(file1.length());

        //方法long lastModified()  获取最后一次的修改时间，毫秒值
        System.out.print("获取文件的最后修改时间：");
        System.out.println(new Date(file1.lastModified()));

        //方法String[] list() 获取指定目录下的所有文件或者文件目录的名称数组
        System.out.println("获取指定目录下的所有文件/目录的名称数组：");
        String[] sArr1 = file2.list();
        for(String s : sArr1) {
            System.out.println(s);
        }

        //方法File[] listFiles()  获取指定目录下的所有文件或者文件目录的File数组
        System.out.println("获取指定目录下所有文件/目录的File数组：");
        File[] sArr2 = file2.listFiles();
        for(File f : sArr2) {
            System.out.println(f.getName());
        }

        //方法

    }

    @Test
    public void useMethod2(){

        //实例化File
        File file1 = new File("txt/hello.txt");
        File file2 = new File("txt2/hello1.txt");

        //方法boolean renameTo(File filename) 把文件重命名为指定的文件路径 相当于剪切
        /**
         * 方法执行成功需要保证调用者存在，目标位置无占用者
         */
        System.out.println("重命名成功：" + file2.renameTo(file1));


    }

    @Test
    public void useMethod3(){

        //实例化File
        File file1 = new File("txt/hello.txt");
        File file2 = new File("txt");

        //方法boolean isDirectory() 判断是否是文件目录
        System.out.print("file1是否是文件目录：");
        System.out.println(file1.isDirectory());
        System.out.print("file2是否是文件目录：");
        System.out.println(file2.isDirectory());

        //方法boolean isFile() 判断是否是文件
        System.out.print("file1是否是文件：");
        System.out.println(file1.isFile());
        System.out.print("file2是否是文件：");
        System.out.println(file2.isFile());

        //方法boolean exists() 判断是否存在
        System.out.print("file1是否存在：");
        System.out.println(file1.exists());

        //方法boolean canRead() 判断是否可读
        System.out.print("file1是否可读：");
        System.out.println(file1.canRead());

        //方法boolean canWrite() 判断是否可写
        System.out.print("file1是否可写：");
        System.out.println(file1.canWrite());

        //方法boolean isHidden() 判断是否隐藏
        System.out.print("file1时候为隐藏文件：");
        System.out.println(file1.isHidden());

        //方法

    }

    @Test
    public void useMethod4() throws IOException {

        //File实例化
        File file1 = new File("txt/hello.txt");
        File file2 = new File("txt/hello1.txt");
        File file3 = new File("txt2");
        File file4 = new File("txt3");

        //方法boolean createNewFile()  创建文件。若文件存在，则不创建，返回false
        System.out.println("file1是否创建成功：" + file1.createNewFile());
        System.out.println("file2是否创建成功：" + file2.createNewFile());

        //方法boolean mkdir() 创建文件目录。如果此文件目录存在，就不创建了。
        //如果此文件目录的上层目录不存在，也不创建。
        System.out.println("file3是否创建成功：" + file3.mkdir());
        System.out.println("file4是否创建成功：" + file4.mkdir());

        //方法boolean mkdirs()  创建文件目录。如果上层文件目录不存在，一并创建
        System.out.println("file3是否创建成功：" + file3.mkdirs());
        System.out.println("file4是否创建成功：" + file4.mkdirs());

        //方法boolean delete()：删除文件或者文件夹
        //删除注意事项：
        //Java中的删除不走回收站。
        //要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
        if(file2.delete()) {
            System.out.println("file2文件删除成功！");
        }

        //方法

    }

}
