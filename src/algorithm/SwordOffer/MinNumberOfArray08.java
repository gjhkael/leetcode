package algorithm.SwordOffer;

/**
 * Created by havstack on 8/27/15.
 */
//求一个旋转数组的最小数字
public class MinNumberOfArray08 {
    public static void main(String[] args){
        int []test={4,5,6,7,8,1,2,3};
        System.out.println(min(test));
    }
    public static int min(int[] array){
        if(array==null||array.length==0){
            return -1;
        }
        int left=0;int right=array.length-1;
        while(left<right){
            int middle=left+(right-left)/2;
            if(array[middle]>array[0]){
                left=middle;
            }

            if(array[middle]<array[array.length-1]){
                right=middle;
            }
            if(right-left==1){
                break;
            }
        }
        return array[right];
    }
}
