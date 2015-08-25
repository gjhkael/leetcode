package algorithm.SwordOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by havstack on 8/24/15.
 */
public class StacksUsingQueue {
    Queue<Integer> queue=new LinkedList<Integer>();

    public void add(int add){
        queue.add(add);
        int size=queue.size();
        while(size>1){
            queue.add(queue.poll());
            size--;
        }
    }
    public void poll(){


    }


}
