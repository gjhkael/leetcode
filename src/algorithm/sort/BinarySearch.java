package algorithm.sort;

/**
 * Created by havstack on 8/24/15.
 */
public class BinarySearch {

    public static void main(String[] args){
        int []test={1,2,3,4,6,44};
        System.out.println(binarySearch(test,44));
    }

    public static boolean binarySearch(int[] nums,int target){
        if(nums==null||nums.length==0)
            return false;
        int left=0,right=nums.length-1;
        while(left<=right){
            int middle=left+(right-left)/2;
            if(nums[middle]<target){
                left=middle+1;
            }else if(nums[middle]>target){
                right=middle-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
