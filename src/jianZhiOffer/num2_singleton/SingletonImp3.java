package jianZhiOffer.num2_singleton;
/**
 * singletonImp3：懒汉多线程模式。
 * singletonImp2只有在单线程下才能实现单例，多线程下在执行if (singletonImp2==null)时，可能会产生多个实例，
 * 因此singletonImp3做了如下改进：为了保证在多线程下实例只被创建一次，需要加同步锁。
 */
public class SingletonImp3 {
    private SingletonImp3(){}

    private static SingletonImp3 singletonImp3 = null;

    public static SingletonImp3 getInstance3(){
        //同步锁
        synchronized (SingletonImp3.class){
            if (singletonImp3==null){
                singletonImp3 = new SingletonImp3();
            }
        }
        return singletonImp3;
    }
}
