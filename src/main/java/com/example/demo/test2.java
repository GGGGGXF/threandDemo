package com.example.demo;

import java.io.*;

/**
 * @author Administrator
 * @create 2018-06-05 17:20
 * @desc 从内存读取数据
 **/
public class test2 {
    public static void main(String[] args) throws Exception {
        File file[] = new File[]{
                new File("D:" + File.separator + "file-a.txt"),
                new File("D:" + File.separator + "file-b.txt")
        };
        /*System.out.println(readFile(file[1]));*/
        String data [] = new String[2];  //定义一个字符串的对象数组
        for (int x = 0; x < file.length ; x ++){
            data[x] = readFile(file[x]);  //读取数据
        }
        StringBuffer buf = new StringBuffer(); //组合操作
        String contentA [] = data[0].split(" "); //根据空格拆分
        String contentB [] = data[1].split(" "); //根据空格拆分
        OutputStream output = new FileOutputStream(new File("D:"+ File.separator +"data.txt"));
        for (int x = 0 ; x < contentA.length ; x ++){
            String str = contentA[x] + "(" + contentB[x] +")";
            buf.append(contentA[x]).append("(").append(contentB[x]).append(")").append(" ");
            output.write(str.getBytes());
        }
        output.close();
        System.out.println(buf);
    }

    /**
     * 如果要读取文件的内容最好传递的是File类对象，因为这个对象一定会包含完整路径
     * @param file
     * @return 返回文件的内容
     */
    public static String readFile(File file) throws Exception {
        if (file.exists()){
            InputStream input = new FileInputStream(file);
            //这里没有向上转型，因为toByteArray()属于子类扩展的方法
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte data [] = new byte[10];
            int temp = 0;
            while ((temp = input.read(data)) != -1){ //内容都在内存流
                bos.write(data,0,temp);
            }
            bos.close();
            input.close();
            return new String(bos.toByteArray()); // 将所有读取的内容返回
        }
        return null;
    }

}
