package jianZhiOffer.num2_singleton;
/**
 * SingletonImp5问题:直接把对象的实例化过程放在静态代码块中存在一个问题：调用任意静态方法，都会创建实例，因此导致过早创建
 * SingletonImp6想要的效果是：只有调用getInstance静态方法时，实例才被创建，调用其他静态方法或者其他任何时候都不会创建实例对象
 * 实现方法：使用一个静态类来创建Singleton，其他静态方法只要没有调用Nested.singletonImp6就不会创建Singleton
 */
public class SingletonImp6 {

    private SingletonImp6(){}

    private static SingletonImp6 singletonImp6 = null;

    //建立了一个静态类用于创建实例
    private static class Inner{
        private static SingletonImp6 singletonImp6;
        static {
            singletonImp6 = new SingletonImp6();
        }
    }

    public static SingletonImp6 getInstance6(){
        return Inner.singletonImp6;
    }

    public static void func() {}

    public static void main(String [] arrs){
        //任何静态方法只要没有用到Nested就不会创建实例对象。只在getInstance方法中才调用Nested.singletonImp6保证了当我们调用SingletonImp的其他静态方法时，实例不会创建。
        func();
        getInstance6();
    }
}
