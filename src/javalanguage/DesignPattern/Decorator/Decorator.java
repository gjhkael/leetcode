package javalanguage.DesignPattern.Decorator;

/**
 * Created by hy on 2015/9/11.
 */
//装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，
// 装饰对象持有被装饰对象的实例
//装饰类
public class Decorator implements Sourceable{
    private Sourceable source;
    public Decorator(Sourceable source){
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before");
        source.method();
        System.out.println("after decorator!");
    }
}
interface Sourceable{
    public void method();
}
//被装饰类
class Source implements  Sourceable{

    @Override
    public void method() {
        System.out.println("this is the original method");
    }
}
