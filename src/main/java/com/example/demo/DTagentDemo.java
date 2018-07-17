package com.example.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Administrator
 * @create 2018-07-05 14:03
 * @desc 动态代理模式
 **/
interface ISubject1 { //代理设计的核心在于需要有一个核心的操作接口
    public void eat(String msg,int num) ; //吃饭是整体的核心业务
}
class RealSubject1 implements ISubject1 {
    @Override
    public void eat(String msg,int num) {
        System.out.println("我要吃！"+ num + "分量的:" + msg);
    }
}
class ProxySubject1 implements InvocationHandler { //是一个动态代理类
    private Object target ; //绑定任意的接口的对象，使用Object描述
    /**
     * 实现真实对象的绑定处理，同时返回代理对象
     * @param target
     * @return 返回一个代理对象（这个对象是根据接口定义动态创建形成的代理对象）
     */
    public  Object bind(Object target) {
        this.target = target ;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public void prepare() {
        System.out.println("【ProxySubject1】准备食材");
    }
    public void clear() {
        System.out.println("【ProxySubject1】清理碗筷");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.prepare();
        Object ret = method.invoke(this.target, args);
        this.clear();
        return ret;
    }
}
public class DTagentDemo {
    public static void main(String[] args) throws Exception{
        ISubject1 subject1 = (ISubject1) new ProxySubject1().bind(new RealSubject1());
        subject1.eat("鱼香肉丝",20);
    }
}

///**
// * 动态代理实现的标识接口，只有实现此接口的子类才具备有动态代理的功能
// *
// */
//public interface InvocationHandler {
//    /**
//     *invoket表示的是调用执行的方法，但是所有的代理类返回给用户的接口对象都属于代理对象
//     * 当用户执行接口方法的时候所调用的实例化对象就是该代理主题动态创建的一个接口对象
//     * @param proxy 表示的是被代理的对象信息
//     * @param method 返回的是被调用的方法对象，取得了Method对象意味着可以使用invoke（）反射调用
//     * @param args 表示方法中接收到的参数
//     * @return 方法的返回值
//     * @throws Throwable 可能产生各种类型的Exception或Error
//     */
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
//}