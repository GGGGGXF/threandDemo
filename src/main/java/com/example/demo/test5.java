package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author Administrator
 * @create 2018-06-14 16:37
 * @desc scanner输入
 **/
public class test5 {
    public static void main(String[] args) throws Exception {
        /**
         * 输入年龄
         */
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入年龄:");
//        if (sc.hasNextInt()){      // 现在有输入内容，不判断空字符
//            Integer age = sc.nextInt();
//            System.out.println("[echo]输入内容为"+age);
//        }else{
//            System.out.println("输出错误！");
//        }
//        sc.close();
        /**
         * 输入生日
         */
//        Scanner sx = new Scanner(System.in);
//        System.out.print("请输入生日:");
//        if (sx.hasNext("\\d{4}-\\d{2}-\\d{2}")){
//            String birthday = sx.next("\\d{4}-\\d{2}-\\d{2}");
//            System.out.println("[echo]"+ birthday);
//        }
//        sx.close();

        /**
         * 文件输入
         */
        Scanner sc = new Scanner(new FileInputStream(new File("D:" + File.separator + "info.txt")));
        //自定义分隔符
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
        sc.close();
    }
}
