package leetcode;

import java.util.HashMap;

/**
 * Created by hy on 2015/7/27.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0||nums==null)
            return false;
        HashMap<Integer,Integer> tmp=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(tmp.containsKey(nums[i]))
                return true;
            else
                tmp.put(nums[i],1);
        }
        return false;
    }
}
