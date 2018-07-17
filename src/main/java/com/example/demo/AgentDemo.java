package com.example.demo;

import java.lang.reflect.Constructor;

/**
 * @author Administrator
 * @create 2018-07-05 11:01
 * @desc 代理设计模式
 **/
interface ISubject { //代理设计的核心在于需要有一个核心的操作接口
    public void eat() ;
}
class RealSubject implements ISubject {
    @Override
    public void eat() {
        System.out.println("饿了要吃饭！");
    }
}
class Factory1 {
    private Factory1() {}
    public static <T> T getInstance(String className) {
        T t = null;
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    public static <T> T getInstance(String proxyclassName,String realclassName) {
        T t = null;
        try {
            Object obj = getInstance(realclassName);
            Constructor<?> cons = Class.forName(proxyclassName).getConstructor(obj.getClass().getInterfaces()[0]);
            t = (T) cons.newInstance(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}

class ProxySubject implements ISubject {
    private ISubject subject ;
    public ProxySubject(ISubject subject) {
        this.subject = subject ;
    }
    public void prepare() {
        System.out.println("需要食材，收拾食材！");
    }

    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();
        this.clear();
    }

    public void clear() {
        System.out.println("吃完洗盘子！");
    }
}

public class AgentDemo {
    public static void main(String[] args) throws Exception{
        ISubject subject = Factory1.getInstance("com.example.demo.ProxySubject","com.example.demo.RealSubject");
        subject.eat();
    }

}
