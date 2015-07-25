package sort;

/**
 * Created by hy on 2015/7/25.
 */
//冒泡排序
public class BubbleSort {
    public static void main(String[] args){
        int[] test={2,5,3,1,6,8,7,10,9};
        ArrayUtils.printArray(test);
        bubbleSort(test);
        ArrayUtils.printArray(test);
    }
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1])
                    ArrayUtils.swap(array,j,j-1);
            }
        }
    }
}
