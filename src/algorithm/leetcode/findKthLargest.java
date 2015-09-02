package algorithm.leetcode;

/**
 * Created by havstack on 8/26/15.
 */
public class findKthLargest {

    public static void main(String[] args){
        int test[]={3,2,4,6};int k=2;
        for(int a:test){
            System.out.println(a);
        }

        System.out.println(new findKthLargest().findKthLargest(test,k));

    }

    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length<k)
            return -1;
        int index=quickSelect(nums,0,nums.length-1,nums.length-k+1);
        return nums[index];
    }

    int quickSelect(int nums[],int left,int right,int k){
        int i=left,j=right;
        int pivot=nums[left];
        while(i<j){
            while(i<j&&nums[j]>=pivot)
                j--;
            if(i<j)
                nums[i++]=nums[j];
            while(i<j&&nums[i]<pivot)
                i++;
            if(i<j)
                nums[j--]=nums[i];
        }
        nums[i]=pivot;
        int m=i-left+1;
        if(m>k){
            return quickSelect(nums,left,i-1,k);
        }else if(m<k){
            return quickSelect(nums,i+1,right,k-m);
        }else{
            return i;
        }
    }

    public void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
