package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by havstack on 8/18/15.
 */
public class ThreeSum {

    public static void main(String[] args){
        int []nums={0,0,0,0};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { //如果i和i+1相同，直接跳过
                int low = i + 1;
                int high = nums.length - 1;
                int sum = nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] + sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] + sum < 0) {
                        low++;
                    } else
                        high--;

                }
            }
        }
        return res;
    }
}
