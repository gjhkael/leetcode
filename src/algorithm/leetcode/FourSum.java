package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by havstack on 8/18/15.
 */
public class FourSum {
    public static void main(String[] args){
        int []nums={0,0,0,0};
        System.out.println(new FourSum().fourSum(nums,3));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums.length<4)
            return result;

        for(int i=0,len=nums.length;i<len-3;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<len-2;j++){
                if(j>i+1&&nums[j]==nums[j-1])continue;
                int low=j+1;int high=len-1;int sum=target-nums[i]-nums[j];
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high&&nums[low]==nums[low+1])low++;
                        while(low<high&&nums[high]==nums[high-1])high--;
                        low++;
                        high--;
                    }else if(nums[low]+nums[high]<sum){
                        low++;
                    }else
                        high--;
                }

            }
        }
        return result;
    }
}
