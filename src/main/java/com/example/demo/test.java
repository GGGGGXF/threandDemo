package com.example.demo;

import java.util.Date;

import static java.lang.Thread.sleep;

class mythred extends Thread {

}

public class test{
    public static void main(String[] args) throws InterruptedException {
        Integer str = 123123;
        sleep(1000);
        System.out.println(str.toString());

    }
}