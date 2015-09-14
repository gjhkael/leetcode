package javalanguage.DesignPattern.Adapter;

/**
 * Created by hy on 2015/9/11.
 */
//类的适配器
public class Adapter extends Source implements Targetable{
    public static void main(String[] args){
        Adapter adapter = new Adapter();
        adapter.method1();
        Source source = new Source();
        Adapter1 adapter1 = new Adapter1(source);
        adapter1.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetble method!");
    }
}
//对象的适配器
class Adapter1 implements Targetable{
     private Source source;
     public Adapter1(Source source){
        this.source = source;
     }

     @Override
     public void method1() {
        source.method1();
     }

     @Override
    public void method2() {
        System.out.println("this is the targetble method!");
    }
}


class Source{
    public void method1(){
        System.out.println("this is original method");
    }
}


class SourceSub extends wrapper{
    public void method1(){
        System.out.println("asdffasdf");
    }
}
//接口的适配器
abstract class wrapper implements Targetable{
    public void method1(){}
    public void method2(){}
}

interface Targetable{
    public void method1();
    public void method2();
}

