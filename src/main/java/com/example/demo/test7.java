package com.example.demo;

/**
 * @author Administrator
 * @create 2018-07-05 10:20
 * @desc java内部classLoad类加载器
 **/
class Member { //自定义的类，这个类一定在ClassPath之中

    @Override
    public String toString() {
        return "Member";
    }
}
public class test7 {
    public static void main(String[] args) throws Exception {
        System.out.println(Class.forName("com.example.demo.Member").getClassLoader().loadClass("com.example.demo.Member").newInstance());
    }
}
