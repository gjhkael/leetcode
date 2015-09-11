package javalanguage.DesignPattern.singleton;

/**
 * Created by hy on 2015/9/11.
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。
 （比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton(){

    }
    public static Singleton getInstance(){  //线程不安全
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static synchronized Singleton getInstance1(){  //每次获取对象都需要加锁和释放锁，性能低下
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }


    /*
    a>A、B线程同时进入了第一个if判断
    b>A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
    c>由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
    d>B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
    e>此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
    */
    public static Singleton getInstance2(){  //java中创建对象和赋值操作是分开进行的，instance = new Singleton()是分两步进行的。
        if(instance == null){
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }



    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }
    public static Singleton getInstance3(){
        return SingletonFactory.instance;
    }
}
