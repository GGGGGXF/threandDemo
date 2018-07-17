package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Administrator
 * @create 2018-06-06 10:30
 * @desc 格式化输出信息
 **/
public class test4 {
    public static void main(String[] args) throws Exception {
        String name = "管晓峰";
        int age = 23;
        double salary = 10000.889;
        PrintWriter pu = new PrintWriter(new FileOutputStream(new File("D:" + File.separator + "info.txt")));
        pu.printf("姓名: %s, 年龄: %d, 工资: %8.2f",name,age,salary);
        pu.close();
    }
}
