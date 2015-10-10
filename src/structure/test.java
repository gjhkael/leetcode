package structure;

import java.util.HashSet;

/**
 * Created by kael on 2015/10/1.
 */
public class test {

    public static void main(String[] args){
        int [] test={-1,100,2,100,100,4,100};
        majorityElement(test);
    }

    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int left=0;
        int right = nums.length-1;
        int mid = nums.length/2;
        int pavoit=0;
        pavoit = partition(nums,left,right);
        while(true){
            if(pavoit==mid){
                break;
            }else if(pavoit<mid){
                System.out.println(pavoit);
                left = pavoit+1;
                pavoit = partition(nums,left,right);
            }else{

                right = pavoit-1;
                pavoit = partition(nums,left,right);
            }
        }
        return nums[pavoit];
    }
    public static int partition(int[] nums,int left,int right){

        int tmp = nums[left];
        if(left>=right){
            return left;
        }
        while(left<right){
            while(left<right && nums[right]>tmp){
                right--;
            }
            if(left<right){
                nums[left++]=nums[right];
            }
            while(left<right && nums[left]<tmp){
                left++;
            }
            if(left<right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = tmp;
        return left;
    }
}
