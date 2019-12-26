package jianZhiOffer.num2_singleton;

/**
 * SingletonImp5:因为静态代码块只在类加载的时候执行一次，所以可以把对象的new放在static{}里面
 */
public class SingletonImp5 {

    private SingletonImp5(){}

    private static SingletonImp5 singletonImp5 = null;

    static {
        singletonImp5 = new SingletonImp5();
    }

    public static SingletonImp5 getInstance5(){
        return singletonImp5;
    }

    public static void func() {}

    public static void main(String [] arrs){
        // 调用任意静态方法，都会创建实例，因此导致过早创建
        func();
        getInstance5();
    }
}
