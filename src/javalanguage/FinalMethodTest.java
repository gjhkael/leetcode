package javalanguage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hy on 2015/8/7.
 */
class Base{
     final void info(){
        System.out.println("hello world");
    }
}
public class FinalMethodTest extends Base{
    protected void test(){

    }

    public static void main(String[] args){
        new FinalMethodTest().info();

        Deque<Integer> stack=new LinkedList<Integer>();
    }

}






















