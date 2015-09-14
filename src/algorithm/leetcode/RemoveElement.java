package algorithm.leetcode;

/**
 * Created by hy on 2015/9/12.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int start =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[start++] = nums[i];
            }
        }
        return start;
    }
}