package dynamic;

/**
 * Created by hy on 2015/7/30.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int test[]=new int[]{-9, -2, -3, -5, -6};
        //System.out.println(maxSubArray(test));

        System.out.println(maxSubArray1(test));
    }

    public static int maxSubArray(int[] nums){
        if(nums.length==0||nums==null)
            return 0;
        int result=Integer.MIN_VALUE;
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            tmp=tmp+nums[i];
            if(result<tmp)
                result=tmp;
            if(tmp<0)
                tmp=0;
        }
        return result;
    }
//动态规划求最大子数组的原理是利用一个数组用来存放每个数最为子数组的最后一个数的时候的最大值
/*
-9, -2, -3, -5, -6
d[0]=nums[0]
d[1]=max{d[0]+nums[i],nums[i]},  这样一直下去，并不断的将获得最大值和max进行比较，若大于max，max取其值。
。。。
 */

    public static int maxSubArray1(int[] nums)   {
        if(nums.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int length=nums.length;
        int []dp=new int[length];
        dp[0]=nums[0];
        for(int i=1;i<length;i++) {
            dp[i]=max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max){
                max=dp[i];
            }
        }

        return max;
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
}
