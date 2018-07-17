package com.example.demo;


class MyThread implements Runnable{
    private int ticket = 1000;

    @Override
    public void run() {
        for (int x = 0; x < 2000; x++){
            this.sale();
        }
    }
    public synchronized void sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买票.ticket=" + this.ticket--);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt,"票贩子A");
        Thread t2 = new Thread(mt,"票贩子B");
        Thread t3 = new Thread(mt,"票贩子C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}