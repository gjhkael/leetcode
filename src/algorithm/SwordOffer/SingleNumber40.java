package algorithm.SwordOffer;

/**
 * Created by havstack on 9/7/15.
 */
public class SingleNumber40 {
    public static void main(String[] args){
        int[] nums={1,1,2,3,4,4,5,5,6,6};
        int[] n=singleNumber(nums);
        System.out.println(n[0]+" "+n[1]);
    }

    public static int[] singleNumber(int[] nums) {
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
