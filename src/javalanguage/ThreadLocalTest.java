package javalanguage;

/**
 * Created by havstack on 8/28/15.
 */
public class ThreadLocalTest {
    public static void main(String[] args){
        Account at=new Account("初始化");
        System.out.println(at.getName());
        new MyTest(at,"线程jia").start();
        new MyTest(at,"线程yi").start();
    }
}
class Account{

    private ThreadLocal<String> name=new ThreadLocal<String>();
    public Account(String str){
        name.set(str);
    }
    public String getName(){
        return name.get();
    }
    public void setName(String str){
        name.set(str);
    }
}

class MyTest extends Thread{
    private Account account;
    public MyTest(Account account,String name){
        super(name);
        this.account=account;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            if(i==6){
                account.setName(getName());
            }
            System.out.println(account.getName()+" 账户的i值："+i);
        }
    }
}
















