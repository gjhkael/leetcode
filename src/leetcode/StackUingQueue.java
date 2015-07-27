package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hy on 2015/7/27.
 */
public class StackUingQueue {


    Queue<Integer> s=new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        s.add(x);
        int size=s.size();
        while(size-->1)
            s.add(s.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        s.poll();
    }

    // Get the top element.
    public int top() {
        return s.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return s.isEmpty();
    }
}
