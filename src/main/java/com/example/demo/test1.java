package com.example.demo;

import java.io.*;

/**
 * @author Administrator
 * @create 2018-06-05 16:54
 * @desc 从内存读取数据
 **/
public class test1 {
    public static void main(String[] args) throws Exception {
        String msg = "hello world!!";
        // 实例化InputStream类对象，实例化的时候需要将你操作的数据保存到内存之中，最终读取的就是你设置的内容
        InputStream input = new ByteArrayInputStream(msg.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1){
            output.write(Character.toUpperCase(temp));//每个字节都要处理
        } //此时所有的数据都在OutputStream类中了
        System.out.println(output);//直接输出对象，调用toString()
        input.close();
        output.close();
    }
}
