package leetcode;

import sort.ArrayUtils;

/**
 * Created by hy on 2015/7/29.
 */
public class RotateArray {
    public static void main(String[] args){
        RotateArray rotateArray=new RotateArray();
        int[] test=new int[]{1,2,3,4,5,6,7,8,9};
        rotateArray.rotate(test, 8);
        ArrayUtils.printArray(test);
    }
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<=k)
            return ;
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k);
        reserve(nums,k+1,nums.length-1);

    }
    public void reserve(int[] nums,int start,int end){
        while(start<end){
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
}
