package sort;

/**
 * Created by gjh on 2015/7/25.
 */
//针对排序写的打印数组方法
public class ArrayUtils {
    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }

    public static void swap(int[] array,int a,int b){
        int tmp=array[a];
        array[a]=array[b];
        array[b]=tmp;
    }


}
