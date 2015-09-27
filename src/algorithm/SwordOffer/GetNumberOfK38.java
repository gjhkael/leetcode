package algorithm.SwordOffer;

/**
 * Created by havstack on 9/7/15.
 */
public class GetNumberOfK38 {

    public static void main(String[] args){
        int nums[]={1,2,3,3,3,4,5,6};
        System.out.println(getNumberOfK(nums,3));
    }


    public static int getNumberOfK(int[] nums,int k){
        if(nums==null || nums.length ==0)
            return -1;
        int first = GetFirstK(nums,k,0,nums.length-1);
        int last = GetLastK(nums,k,0,nums.length-1);
        System.out.println(first + " "+ last);
        if(first>-1&&last>-1)
            return last - first +1;
        return -1;
    }

    public static int GetFirstK(int[] nums,int k,int left,int right){
        if(left>right){
            return -1;
        }
        int middleIndex = left+(right-left)/2;
        int middleData = nums[middleIndex];
        if(middleData == k){
            if(middleIndex>0 && nums[middleIndex-1]!=k || middleIndex==0)
                return middleIndex;
            else{
                right = middleIndex-1;
            }
        }else if (middleData > k){
            right = middleIndex-1;
        }else{
            left = middleIndex +1;
        }
        return GetFirstK(nums,k,left,right);
    }

    public static int GetLastK(int[] nums,int k,int left,int right){
        if(left>right){
            return -1;
        }
        int middleIndex = left+(right-left)/2;
        int middleData = nums[middleIndex];
        if(middleData == k){
            if(middleIndex<right && nums[middleIndex+1]!=k || middleIndex==right)
                return middleIndex;
            else{
                left = middleIndex+1;
            }
        }else if (middleData > k){
            right = middleIndex-1;
        }else{
            left = middleIndex +1;
        }
        return GetLastK(nums, k, left, right);

    }

}
