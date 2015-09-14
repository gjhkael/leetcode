package algorithm.SwordOffer;

/**
 * Created by havstack on 9/7/15.
 */

//利用归并排序的算法思路来解决逆序对问题
public class InversePairs {

    public static void main(String[] args){
        int test[]={7,5,6,4};
        System.out.println(inversePairs(test));
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }

    public static int inversePairs(int[] nums){
        if(nums==null || nums.length==0)
            return 0;
        int length = nums.length;
        int result =0;
        result=inversePairs(nums,0,length-1);
        return  result;
    }

    public static int inversePairs(int[] nums,int left,int right){
        int []tmp = new int[nums.length];
        if(left==right)
            return 0;
        int middle = left+(right-left)/2;
        int leftNums = inversePairs(nums,left,middle);
        int rightNums = inversePairs(nums,middle+1,right);
        int count = 0;
        int rightIndex = right;
        int leftIndex = middle;
        int tmpIndex=nums.length-1;
        while(left<=leftIndex && middle<rightIndex){
            if(nums[leftIndex]>nums[rightIndex]){
                tmp[tmpIndex--] = nums[leftIndex--];
                count += rightIndex-middle;
            }else{
                tmp[tmpIndex--] = nums[rightIndex--];
            }
        }
        while(leftIndex>=left){
            tmp[tmpIndex--] = nums[leftIndex--];
        }
        while(rightIndex>middle){
            tmp[tmpIndex--] = nums[rightIndex--];
        }
        tmpIndex=nums.length-1;
        for(int i=right;i>=left;i--){
            nums[i]=tmp[tmpIndex--];
        }
        return leftNums+rightNums+count;
    }

}
