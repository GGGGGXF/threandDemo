package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Administrator
 * @create 2018-06-06 9:59
 * @desc 使用系统打印流
 **/
public class test3 {
    public static void main(String[] args) throws Exception{
        PrintWriter pu = new PrintWriter(new FileOutputStream(new File("D:"+ File.separator + "info.txt")));
        pu.print("姓名: ");
        pu.println("管晓峰");
        pu.println(1 + 10);
        pu.println(1.2 + 10.5);
        pu.close();
    }
}
