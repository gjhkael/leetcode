package sort;

/**
 * Created by hy on 2015/7/28.
 */
public class InserSort {
    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        ArrayUtils.printArray(data5);
        insertSort(data5);
        ArrayUtils.printArray(data5);
    }

    public static void insertSort(int[] data){
        for(int i=1;i<data.length;i++){
            for(int j=i;j>0;j--){
                if(data[j]<data[j-1]){
                    ArrayUtils.swap(data,j-1,j);
                }
            }
        }
    }
}
