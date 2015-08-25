package algorithm.SwordOffer;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by havstack on 8/24/15.
 */
public class QueueUsingStacks {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void add(int add){
        while(stack2.size()>0){
            stack1.push(stack2.pop());
        }
        stack1.push(add);

    }

    public void remove(){
        while(stack1.size()>0){
            stack2.push(stack1.pop());
        }
        stack2.pop();
    }
}
