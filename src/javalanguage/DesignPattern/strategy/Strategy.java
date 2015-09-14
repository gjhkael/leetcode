package javalanguage.DesignPattern.strategy;

/**
 * Created by hy on 2015/9/12.
 */
public class Strategy {
}
interface Sourceable{
    public void method();
}

class SourceSub1 implements Sourceable{
    @Override
    public void method() {
        System.out.println("this is the first sub");
    }
}

class SourceSub2 implements Sourceable{

    @Override
    public void method() {
        System.out.println("this is the second sub");
    }
}

class Bridge1{
    private Sourceable source;
    public void method(){
        source.method();
    }

    public Sourceable getSource(){
        return source;
    }
    public void setSource(Sourceable source){
        this.source = source;
    }
}

