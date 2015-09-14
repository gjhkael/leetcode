package algorithm.leetcode;

/**
 * Created by hy on 2015/9/12.
 */
public class MergeTwoSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null || n<=0){
            return ;
        }
        int index = m+n-1;
        int numsIndex1 = m-1;
        int numsIndex2 = n-1;

        while(numsIndex1>=0 && numsIndex2 >=0){
            if(nums1[numsIndex1]>nums2[numsIndex2]){
                nums1[index--]=nums1[numsIndex1--];
            }else{
                nums1[index--]=nums2[numsIndex2--];
            }
        }
        if(numsIndex2>=0){
            while(numsIndex2>=0){
                nums1[index--]=nums2[numsIndex2--];
            }
        }
    }
}
