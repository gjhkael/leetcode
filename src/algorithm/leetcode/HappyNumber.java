package algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by hy on 2015/7/27.
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
    public static void main(String[] args){
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        if(n<=0)
            return false;
        if(n==1)
            return true;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        while(true){
            int result=0;
            map.put(n,1);
            while(n>=10){
                int tmp=n%10;
                result+=tmp*tmp;
                n=n/10;
            }
            result+=n*n;
            if(map.containsKey(result)){
                return false;
            }
            if(result==1)
                return true;
            n=result;
        }
    }
}
