package array;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by kael on 6/9/15.
 */
public class SumOfkNumber {
    public static void main(String[] args){
        sumOfkNumber(10,10);

    }
    static Queue<Integer> list=new PriorityBlockingQueue<Integer>();
    public static void sumOfkNumber(int sum,int n){
        if(sum<=0||n<=0){
            return;
        }

        if(sum==n){
            for(Integer a:list){
               System.out.print(a + "+");
            }
            System.out.println(n);
        }

        list.offer(n);
        sumOfkNumber(sum-n,n-1);
        list.poll();
        sumOfkNumber(sum,n-1);
    }


}
