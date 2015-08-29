package algorithm.leetcode;

import java.util.Stack;

/**
 * Created by havstack on 8/12/15.
 */
public class LargestRectangleArea {


    public static void main(String[] args){
        int test[]={4,2};
        System.out.println(largestRectangleArea(test));
    }

    public static int largestRectangleArea(int[] height) {
        if(height.length==0)
            return 0;
        if(height.length==1)
            return height[0];

        int max_area=0;
        Stack<Integer> stack=new Stack<Integer>();
        int length=height.length;
        int i=0;
        while(i<length){
            if(stack.isEmpty() || height[i]>=height[stack.peek()]) {
                //System.out.println(i);
                stack.push(i++);
            }else{
                int tmp=stack.pop();

                max_area=max(max_area, height[tmp]*(stack.isEmpty()?i:i-stack.peek()-1));
            }
        }

        while(!stack.isEmpty()){
            int tmp=stack.pop();
           // System.out.println(max_area);
            max_area=max(max_area,height[tmp]*(stack.isEmpty()?i:i-stack.peek()-1));
        }
        return max_area;

    }

    public static int max(int a,int b){
        return a>b?a:b;
    }

}
