package javalanguage;

/**
 * Created by havstack on 8/28/15.
 */
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 /**
  * 使用Lock来实现生产者和消费者问题
  *
  * @author 刘玲
  *
  */
public class ProduceAndCoustomerLock {
    public static void main(String[] args) {
         Basket b = new Basket();
         Product p = new Product(b);
         Consumer c = new Consumer(b);
         Consumer c1 = new Consumer(b);
         new Thread(p).start();
         new Thread(c).start();
         new Thread(c1).start();
     }
 }
//馒头
class ManTou{
     int id;
     public ManTou(int id) {
         this.id = id;
     }
     @Override
     public String toString() {
         return "ManTou"+id;
     }
}

 //装馒头的篮子
class Basket{
     int max = 6;
     LinkedList<ManTou> manTous = new LinkedList<ManTou>();
     Lock lock = new ReentrantLock(); //锁对象
     Condition full = lock.newCondition();  //用来监控篮子是否满的Condition实例
     Condition empty = lock.newCondition(); //用来监控篮子是否空的Condition实例
     //往篮子里面放馒头
     public void push(ManTou m){
         lock.lock();
         try {
             while(max == manTous.size()){
                 System.out.println("篮子是满的，待会儿再生产...");
                 full.await();
             }
             manTous.add(m);
             empty.signal();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally{
             lock.unlock();
         }
     }
     //往篮子里面取馒头
     public ManTou pop(){
         ManTou m = null;
         lock.lock();
         try {
             while(manTous.size() == 0){
                 System.out.println("篮子是空的，待会儿再吃...");
                 empty.await();         //调用了这个方法的时候会直接执行finally中进行锁的释放
             }
             m = manTous.removeFirst();
             full.signal();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally{
             System.out.println("篮子是空的，释放锁"+manTous.size());
             lock.unlock();
             return m;
         }
     }
}
//生产者
class Product implements Runnable{
     Basket basket;
     public Product(Basket basket) {
         this.basket = basket;
     }
     public void run() {
         for (int i = 0; i < 40; i++) {
             ManTou m = new ManTou(i);
               basket.push(m);
             System.out.println("生产了"+m);
             try {
                 Thread.sleep((int)(Math.random()*2000));
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
}
//消费者
class Consumer implements Runnable{
     Basket basket;
     public Consumer(Basket basket) {
         this.basket = basket;
     }
     public void run() {
         for (int i = 0; i < 20; i++) {
             try {
                 Thread.sleep((int)(Math.random()*2000));
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             ManTou m = basket.pop();
             System.out.println("消费了"+m);
         }
     }
}