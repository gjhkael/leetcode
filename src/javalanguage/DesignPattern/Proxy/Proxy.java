package javalanguage.DesignPattern.Proxy;

/**
 * Created by hy on 2015/9/11.
 */
public class Proxy implements Sourceable{
    private Source source;
    public Proxy(){
        this.source = new Source();
    }
    @Override
    public void method() {
       source.method();
    }
}

interface Sourceable{
    public void method();
}
class Source implements Sourceable{

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}