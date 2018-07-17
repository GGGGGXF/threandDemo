package com.example.demo;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Administrator
 * @create 2018-06-14 17:07
 * @desc 序列化
 **/
class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "NAME='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


public class test6 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = sc1.next();
        Scanner sc2 = new Scanner(System.in);
        System.out.print("请输入年龄：");
        int age = sc2.nextInt();
        Person p1 = new Person(name,age);
        System.out.println(p1.toString());
    }
}
