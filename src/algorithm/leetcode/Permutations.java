package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/9/29.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        if(nums.length==0||nums==null)
            return result;

        permute(nums,0,nums.length-1,result);
        return result;


    }
    public void permute(int[]nums,int start,int end,List<List<Integer>> result){
        if(start>=end){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                tmp.add(nums[i]);
            }
            result.add(tmp);
            return ;
        }else{
            for(int i=start; i<=end;i++){
                int tmps = nums[start];
                nums[start] = nums[i];
                nums[i] = tmps;
                permute(nums,start+1,end,result);
                tmps = nums[start];
                nums[start] = nums[i];
                nums[i] = tmps;
            }
        }
    }
}
