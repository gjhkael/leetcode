package algorithm.leetcode;

/**
 * Created by hy on 2015/8/10.
 */
public class ContainsNearByAlmostDuplicate {

    public static void main(String[] args){
        int[]test={-1,-1};
        System.out.println(containsNearbyAlmostDuplicate(test,1,0));
    }


    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length==0|| k<=0 || t<0)
            return false;
        int pre=0,after=0;
        for(int i=0;i<k;i++){
            pre++;
        }
        while(pre<nums.length){
            if(Math.abs(nums[pre]-nums[after])==t)
                return true;
            pre++;
            after++;
        }
        return false;

    }
}
