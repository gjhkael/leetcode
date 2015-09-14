package algorithm.leetcode;

/**
 * Created by kael on 8/29/15.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        int length=nums.length;
        int result=nums[0];
        for(int i=1;i<length;i++){
            result=result^nums[i];
        }
        return result;
    }
}
