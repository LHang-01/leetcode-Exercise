package jianZhiOffer.num2_singleton;

/**
 * 面试题2：单例设计
 * 单例模式需要满足如下规则：
 * 1）构造函数私有化（private），使得不能直接通过new的方式创建实例对象；
 * 2）通过new在代码内部创建一个（唯一）的实例对象；
 * 3）定义一个public static的公有静态方法，返回上一步中创建的实例对象；由于在静态方法中，所以上一步的对象也应该是static的。
 *
 * SingletonImp1:饿汉模式，先直接new一个出来
 */
public class SingletonImp1 {
    //1）构造函数私有化（private）
    private SingletonImp1(){}
    //2）通过new在代码内部创建一个（唯一）的实例对象；
    private static SingletonImp1 singletonImp1 = new SingletonImp1();
    //3）定义一个public static的公有静态方法返回实例对象(由于在静态方法中，所以对象也应该是static的)
    public static SingletonImp1 getInstance1(){
        return singletonImp1;
    }
}
