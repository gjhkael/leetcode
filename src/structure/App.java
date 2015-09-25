package structure;

/**
 * Created by hy on 2015/9/25.
 */
public class App {

    public static void main(String[] args){
        int [] nums ={1,2,3,4,5,6,7,10};
        System.out.println(binarySearch(nums,7));
    }
    public static boolean binarySearch(int[] nums,int key){
        if(nums==null || nums.length==0){
            return false;
        }
        int left = 0; int right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] == key){
                return true;
            }else if(nums[mid]>key){
                right = mid-1;
            }else
                left = mid+1;
        }
        return false;
    }
}
