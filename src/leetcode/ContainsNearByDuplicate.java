package leetcode;

import java.util.HashMap;

/**
 * Created by hy on 2015/7/27.
 */
public class ContainsNearByDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0|| nums==null)
            return false;
        HashMap<Integer,Integer> tmp=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(tmp.containsKey(nums[i])){
                if((i-tmp.get(nums[i]))<=k)
                    return true;
                else
                    tmp.put(nums[i],i);
            }else
                tmp.put(nums[i],i);
        }
        return false;
    }
}
