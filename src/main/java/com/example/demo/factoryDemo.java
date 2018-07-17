package com.example.demo;

/**
 * @author Administrator
 * @create 2018-07-03 14:15
 * @desc 传统工厂类
 * 1.传统工厂类最大弊端：关键字 new,造成耦合问题
 * 2.可以通过反射来进行处理，因为Class类
 * 可以使用newInstance()实例化对象，
 * 同时Class.forName()能够接收String
 * 这个类名称
 * 3.使用泛型的工厂类
 *
 **/
interface IFruit {
    public void eat() ;
}
interface IMessage {
    public void print() ;
}
class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("一行数据！");
    }
}
class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("【Apple】吃苹果");
    }
}
/*class Orange implements IFruit {
    @Override
    public void eat() {
        System.out.println("【Orange】吃橘子");
    }
}*/
class Factory {
    private Factory() {}
    public static <T> T getInstance(String className) {
        /*if("apple".equals(className)){
            return new Apple();
        }else if("orange".equals(className)){
            return new Orange();
        }*/
        T Obj = null ;
        try {
            Obj = (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Obj;
    }
}
public class factoryDemo {
    public static void main(String[] args) throws Exception{
/*        IFruit fruit = Factory.getInstance("apple");*/
        IFruit fruit = Factory.getInstance("com.example.demo.Apple");
        fruit.eat();
        IMessage msg = Factory.getInstance("com.example.demo.MessageImpl");
        msg.print();
    }
}
