package jianZhiOffer.num2_singleton;
/**
 * singletonImp4：懒汉多线程模式。
 * singletonImp3为了保证在多线程下实例只被创建一次加同步锁,但是每次调用方法时候都会加锁，加锁是很耗时的。
 * 因此做了如下改进：双重判断：为了保证在对象为null时，只new出一个实例，只在这个时候加锁就够了。
 */
public class SingletonImp4 {
    private SingletonImp4(){}

    private static SingletonImp4 singletonImp4 = null;

    public static SingletonImp4 getInstance4(){
        //双重判断
        if (singletonImp4==null){
            //保证在对象为null时，加锁。
            synchronized (SingletonImp4.class){
                if (singletonImp4==null){
                    singletonImp4 = new SingletonImp4();
                }
            }
        }
        return singletonImp4;
    }
}
