package jianZhiOffer.num2_singleton;

/**
 * singletonImp2：懒汉单线程模式，当singletonImp2为空时才new，不为空时则直接返回singletonImp2。
 */
public class SingletonImp2 {

    private SingletonImp2(){}

    private static SingletonImp2 singletonImp2 = null;

    public static SingletonImp2 getInstance2(){
        //当singletonImp2为空时才new，不为空时则直接返回singletonImp2。
        if (singletonImp2==null){
            return new SingletonImp2();
        }else {
            return singletonImp2;
        }
    }
}

