package com.print;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author hjb
 * @Date 15/7/2021 下午 3:33
 * @Version 1.0
 * @Contact 1754729389@qq.com
 * @Description 打印流PrintStream和PrintWriter
 */
public class PrintSW {

    @Test
    public void usePrintStream(){
        PrintStream ps = null;

        try {
            //流的创建
            FileOutputStream fos = new FileOutputStream("dir1/hello4.txt",true);
            //第二个参数设置打印流为自动刷新模式(遇到"\n"或换行符自动输出缓冲区)
            ps = new PrintStream(fos,true);

            //修改标准输出的位置
            if(ps != null){
                System.setOut(ps);
            }

            for(int i = 0;i < 100;i++){
                System.out.print((char)i);
                if(i % 20 == 0){
                    System.out.println();
                }
            }
            System.out.println("Data output completed.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if(ps != null){
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
