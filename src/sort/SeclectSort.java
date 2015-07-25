package sort;

/**
 * Created by hy on 2015/7/25.
 */
//选择排序，复杂度为n的平方，
public class SeclectSort {
    public static void main(String[] args){
        int[] test={2,5,3,1,6,8,7,10,9};
        ArrayUtils.printArray(test);
        selectSort(test);
        ArrayUtils.printArray(test);
    }

    public static void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int minIndex=i;
            int min=array[i];
            for(int j=i;j<array.length;j++){  //选择最小的元素和第i个数进行交换
                if(array[j]<min){
                    minIndex=j;
                    min=array[j];
                }
            }
            ArrayUtils.swap(array,i,minIndex);
        }
    }
}
