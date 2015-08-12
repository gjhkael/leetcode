package algorithm.leetcode;

import java.util.Stack;

/**
 * Created by hy on 2015/8/11.
 */
public class MinStack {


    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void push(int x) {
        stack1.push(x);
        if(stack2.size()==0)
            stack2.push(x);
        else{
            if(x<stack2.peek())
                stack2.push(x);
            else
                stack2.push(stack2.peek());
        }


    }

    public void pop() {
        if(!stack1.isEmpty()){
            stack1.pop();
            stack2.pop();
        }

    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

}
