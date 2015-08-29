package algorithm.leetcode;

/**
 * Created by havstack on 8/28/15.
 */
public class MissingNumber {


    public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return (nums.length+1)*(nums.length)/2-sum;
    }
}
