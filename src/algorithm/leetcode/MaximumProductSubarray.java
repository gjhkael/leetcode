package algorithm.leetcode;

/**
 * Created by hy on 2015/9/10.
 */
public class MaximumProductSubarray {



    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxEnd=nums[0];
        int minEnd=nums[0];
        int maxResult=nums[0];
        for(int i=1;i<nums.length;i++){
            int end1=maxEnd*nums[i];
            int end2=minEnd*nums[i];
            maxEnd=Math.max(Math.max(end1,end2),nums[i]);
            minEnd=Math.min(Math.min(end1,end2),nums[i]);
            maxResult=Math.max(maxResult,maxEnd);
        }
        return maxResult;
    }
}
