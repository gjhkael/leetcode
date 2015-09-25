package javalanguage;

/**
 * Created by hy on 2015/9/24.
 */
class MyThread extends Thread{

    private int ticket = 10;
    private String name;
    public MyThread(String name){
        this.name =name;
    }

    public void run(){
        for(int i =0;i<500;i++){
            if(this.ticket>0){
                System.out.println(this.name+"卖票---->"+(this.ticket--));
            }
        }
    }
}
public class ThreadDemo {


    public static void main(String[] args) {
        MyThread mt1= new MyThread("一号窗口");
        MyThread mt2= new MyThread("二号窗口");
        MyThread mt3= new MyThread("三号窗口");
        mt1.start();
        mt2.start();
        mt3.start();
    }

}
