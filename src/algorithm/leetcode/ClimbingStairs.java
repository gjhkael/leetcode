package algorithm.leetcode;

/**
 * Created by hy on 2015/9/1.
 */
public class ClimbingStairs {

    public static void main(String[]args){
        System.out.println(new ClimbingStairs().climbStairs(10));
    }
    public int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int []tmp=new int[n];
        tmp[0]=1;
        tmp[1]=2;
        for(int i=2;i<n;i++){
            tmp[i]=tmp[i-1]+tmp[i-2];
        }
        return tmp[n-1];
    }
}
