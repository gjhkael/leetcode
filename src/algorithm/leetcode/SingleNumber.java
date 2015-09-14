package algorithm.leetcode;

/**

 * Created by kael on 8/29/15.
 */



public class SingleNumber {


    public int[] singleNumber(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        int []result=new int[2];
        int tmp=nums[0];
        for(int i=1;i<nums.length;i++){
            tmp=tmp^nums[i];
        }
        tmp&=-tmp;
        for(int i=0;i<nums.length;i++){
            if((tmp&nums[i])==0){
                result[0]=result[0]^nums[i];
            }else{
                result[1]=result[1]^nums[i];
            }
        }

        return result;

    }
}
