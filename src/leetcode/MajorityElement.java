package leetcode;

/**
 * Created by kael on 8/9/15.
 */
public class MajorityElement {


    public static void main(String[] args){
        int[] nums=new int[]{-1,100,2,100,100,4,100};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        int index=0;
        int sum=1;
        for(int i=1;i<nums.length;i++){

            if(nums[i]==nums[index])
                sum++;
            else
                sum--;
            if(sum==0){
                index=i;
                sum=1;
            }


        }
        if(sum==0)
            index=nums.length-1;
        return nums[index];
    }

}
