package algorithm.SwordOffer;

/**
 * Created by hy on 2015/9/6.
 */
public class MoreThanHalfNum {

    public static int MoreThanHalfNum(int[] nums){  //基于块排的partition方法
        if(nums.length==0||nums==null){
            return -1;
        }
        int length = nums.length;
        int middle = length>>1;
        int left =0;
        int right = length-1;
        int index = partition(nums,left,right);
        while(index != middle){
            if(index > middle){
                right = index-1;
                index = partition(nums,left,right);
            }else{
                left = index +1;
                index= partition(nums,left,right);
            }
        }
        int result = nums[middle];
        if(!checkMoreThanHalf(nums,result)){
            result=0;
        }
        return result;
    }

    public static int partition(int [] nums,int left,int right){
        int tmp=nums[left];
        if(left>=right)
            return left;
        while(left<right) {
            while (left < right && nums[right]>tmp) {
                right--;
            }
            if(left<right){
                nums[left++]=nums[right];
            }
            while(left <right && nums[left]<tmp){
                left++;
            }
            if(left<right){
                nums[right--]=nums[left];
            }
        }
        nums[left]=tmp;
        return left;
    }


    public static boolean checkMoreThanHalf(int[] nums,int number){
        int times=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]==number)
                times++;
        }
        if(times*2<length){
            return false;
        }
        return true;
    }

    public static int moreThanHalfNums(int []nums){  //基于数组的特性来做
        if(nums==null||nums.length==0)
            return 0;
        int times=1;
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            if(times==0) {
                result = nums[i];
                times = 1;
            }
            if(nums[i]==result){
                times++;
            }else{
                times--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] test={1,2,2,3,2,3,3,3};
        System.out.println(MoreThanHalfNum(test));
    }


}
