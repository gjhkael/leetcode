package javalanguage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by havstack on 8/28/15.
 */
class WareHouse {

    // 存货物的容器
    List<String> store = new ArrayList<String>();
    public WareHouse() {
    }
    // 存货物的动作
    public void stock(String product) {
        synchronized (this) {
            // 往仓库中存一个货物
            System.out.println("卖家已经存入了货物：" + product + ",通知等待得购买者");
            store.add(product);
            // 通知购买者来取
            this.notify();
        }
    }
    // 取货物的动作
    public void buy() {
        synchronized (this) {
            if (store.size() == 0) {
                System.out.println("仓库目前没有货物，请等待。。。。");
                try {
                    this.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String p = store.remove(0);
            System.out.println("买家已经买到了货物：" + p);
        }
    }
}


//生产者类

 class Seller implements Runnable{
    private WareHouse wareHouse;

    public Seller(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            wareHouse.stock("product"+i);
        }
    }
}

//消费者类
/**
 * 购买者
 * @author Administrator
 *
 */
 class Buyer implements Runnable{
    private WareHouse wareHouse;//仓库
    public Buyer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            wareHouse.buy();
        }
    }
}

// 测试类
/**
 * 测试通信
 * @author Administrator
 *
 */
public class ProduceAndCoustomer {
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();
        Buyer buyer = new Buyer(wareHouse);
        Thread buyThread = new Thread(buyer);
        Seller seller = new Seller(wareHouse);
        Thread sellThread = new Thread(seller);
        buyThread.start();
        sellThread.start();
    }
}


/*
synchronized (this) {
        if (store.size() == 0) {
        System.out.println("仓库目前没有货物，请等待。。。。");
        try {
        this.wait();
        }

        catch (InterruptedException e) {
        e.printStackTrace();
        }
        }

        }
        String p = store.remove(0);
        System.out.println("买家已经买到了货物：" + p);


        写法2

synchronized (this) {
        if (store.size() == 0) {
        System.out.println("仓库目前没有货物，请等待。。。。");
        try {
        this.wait();
        }

        catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
        String p = store.remove(0);
        System.out.println("买家已经买到了货物：" + p);
        }
*/