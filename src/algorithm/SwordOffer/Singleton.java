package algorithm.SwordOffer;

/**
 * Created by gjh on 2015/7/30.
 */
//创建单例模式的方法比较多，有七八种，主要考虑线程安全不安全，还有就是效率

public class Singleton {

    //private static Singleton singleton=new Singleton();  //这里创建对象的话，之后不需要再采用同步机制
    private static Singleton singleton=null;
    private Singleton(){

    }
    public static Singleton getSingleton(){
        if( singleton==null){
            synchronized (Singleton.class){
                if(singleton==null)
                    singleton = new Singleton();
            }
        }
        return singleton;
        //return SingletonHolder.INSTANCE;//第三种方法
    }

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

}
