package algorithm.leetcode;

/**
 * Created by hy on 2015/9/12.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]>nums[i-1])
                nums[i++] = nums[j];
        }
        return i;
    }
}
