package algorithm.SwordOffer;

/**
 * Created by havstack on 9/6/15.
 */
//给定一个数组，判断该数组是不是一颗二叉排序树的后续遍历
public class VerifySquenceOfBST {

    public static void main(String[] args){
        int[] nums={7,4,6,5};
        System.out.println(verifySquenceOfBST(nums,0,3));

    }


    public static boolean verifySquenceOfBST(int[] nums,int start,int end){
        if(nums==null)
            return false;
        if(start>=end){
            return true;
        }
        boolean result;
        int indexOfLeft=start;
        while(start<end&&nums[indexOfLeft]<nums[end]){
            indexOfLeft++;
        }
        int indexOfRight=indexOfLeft;
        while(start<end &&indexOfRight < end)
        {
            if(nums[indexOfRight]<nums[end])
                return false;
            indexOfRight++;
        }
        System.out.println(indexOfLeft+" "+ (end-1));
        boolean left = verifySquenceOfBST(nums,start,indexOfLeft-1);
        boolean right = verifySquenceOfBST(nums,indexOfLeft,end-1);
        result = left && right;
        return result;
    }

}
