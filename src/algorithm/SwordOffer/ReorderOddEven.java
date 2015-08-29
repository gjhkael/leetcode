package algorithm.SwordOffer;

/**
 * Created by havstack on 8/28/15.
 */
public class ReorderOddEven {

    public static void main(String[] args){
        int []test={1,2,3,4,5,6,7};
        reorderOddEven(test);
        for(int num:test){
            System.out.println(num);
        }

    }

    public static void reorderOddEven(int[] nums){
        if(nums.length==0||nums==null){
            return;
        }
        int left=0;int right=nums.length-1;
        while(left<right){
            while(left<right&&nums[left]%2!=0)
                left++;
            while(left<right&&nums[right]%2==0)
                right--;
            if(left<right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
    }
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
