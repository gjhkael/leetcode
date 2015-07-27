package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjh on 2015/7/27.
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if(nums==null){
            return null;
        }
        List<String> result=new ArrayList<String>();
        int index=0;
        for(int i=0;i<nums.length;i++){

            if((i+1)==nums.length){
                if((i+1-index)==1){

                    result.add(""+nums[i]);
                    return result;
                }
                else{

                    result.add(""+nums[index]+"->"+nums[i]);
                    return result;
                }
            }
            if((nums[i+1]-nums[i])==1){

            }else{
                if(i+1-index==1){
                    result.add(""+nums[index]);
                    index=i+1;
                }else{
                    result.add(""+nums[index]+"->"+nums[i]);
                    index=i+1;
                }
            }
        }
        return result;

    }
}
