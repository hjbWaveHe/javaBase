package com.fileIO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author hjb
 * @Date 11/7/2021 下午 5:25
 * @Version 1.0
 * @Contact 1754729389@qq.com
 */
public class FileUtility {

    /**
     * 实现对文件的加密/解密操作
     * @param srcPath 源文件的位置
     * @param destPath 加密/解密后文件的存放位置
     * @return
     */
    public static boolean encryptFile(String srcPath,String destPath){

        boolean isComplete = false;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //流的创建
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));

            //数据的存取
            byte[] bytes = new byte[1024];
            int len;
            while((len = bis.read(bytes)) != -1){
                for(int i = 0;i < len;i++){
                    bytes[i] = (byte)(bytes[i] ^ 5);
                }
                bos.write(bytes,0,len);
            }
            System.out.println("The file is encrypted.");
            isComplete = true;
            return isComplete;
        } catch (IOException e) {
            e.printStackTrace();
            return isComplete;
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

    /**
     * 统计文件中每个字符出现的个数
     * @param srcPath 源文件的位置
     * @param destPath 查询结果所存放的的文件位置
     */
    public static void WordCount(String srcPath,String destPath) {
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //1.创建Map集合
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            //2.遍历每一个字符,每一个字符出现的次数放到map中
            fr = new FileReader(srcPath);
            int c = 0;
            while ((c = fr.read()) != -1) {
                //int 还原 char
                char ch = (char) c;
                // 判断char是否在map中第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            //3.把map中数据存在文件count.txt
            //3.1 创建Writer
            bw = new BufferedWriter(new FileWriter(destPath));

            //3.2 遍历map,再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t'://\t表示tab 键字符
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r'://
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n'://
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
