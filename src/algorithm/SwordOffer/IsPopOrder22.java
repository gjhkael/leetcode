package algorithm.SwordOffer;

import java.util.Stack;

/**
 * Created by havstack on 9/6/15.
 */
//判断第二个数组是不是第一个数组的出栈顺序。
public class IsPopOrder22 {

    public static void main(String[] args){
        int[] nums1={1,2,3,4,5};
        int[] nums2={4,5,2,3,1};
        System.out.println(isPopOrder(nums1,nums2));
    }

    public static boolean isPopOrder(int[] nums1,int[] nums2){
        if(nums1.length != nums2.length || nums1.length == 0)
            return false;
        boolean result = false;
        int length = nums1.length;
        int numIndex1 =0,numIndex2 =0;
        Stack<Integer> stack=new Stack<Integer>();
        while(numIndex2 < length){
            while(stack.empty() || nums2[numIndex2] != stack.peek()){   //思路是：如果栈顶元素不等于num2当前元素的话，直接进栈，
                if(numIndex1 == length){   //全部元素进栈了，这里需要做处理，否则会出现数组越界
                    break;
                }
                stack.push(nums1[numIndex1++]);
            }
            if(stack.peek()!=nums2[numIndex2])
                break;
            stack.pop();
            numIndex2 ++;
        }
        //System.out.println(numIndex1+" "+numIndex2);
        if(stack.empty()&&numIndex2==length)
            result=true;
        return result;
    }
}
