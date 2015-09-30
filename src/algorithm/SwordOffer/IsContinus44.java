package algorithm.SwordOffer;

import java.util.Arrays;

/**
 * Created by hy on 2015/9/28.
 */
public class IsContinus44 {

    public static void main(String[] args){
        int[] nums ={1,0,3,6,5};
        System.out.println(isContinus(nums));
    }

    public static boolean isContinus(int[] nums){
        if(nums==null || nums.length==0){
            return false;
        }
        Arrays.sort(nums);
        int countZero = 0;
        int countGap =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                countZero++;
            }
        }
        int small = countZero;
        int big = small+1;
        while(big<nums.length){
            if(nums[big]==nums[small]){
                return false;
            }
            countGap+=nums[big]-nums[small]-1;
            ++small;
            ++big;
        }

        if(countZero>=countGap){
            return true;
        }else{
            return false;
        }
    }

}
