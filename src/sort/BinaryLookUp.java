package sort;

/**
 * Created by hy on 2015/7/31.
 */
public class BinaryLookUp {
    public static void main(String[] args){
        int []test=new int[]{1,2,3,4,6,6,7,8,9};
        System.out.println(binaryLookup(test,0,8,6));
    }
    public static int binaryLookup(int[] array,int start,int end,int target){
        if(array.length==0)
            return -1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
