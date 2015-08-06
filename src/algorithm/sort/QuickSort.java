package algorithm.sort;

/**
 * Created by hy on 2015/7/25.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        ArrayUtils.printArray(data5);
        quickSort(data5,0,8);
        ArrayUtils.printArray(data5);
    }

    public static void quickSort(int[] array,int left,int right){
        if(null==array || array.length==0){
            return ;
        }
        if(left>=right){
            return ;
        }
        int middle = left+(right-left)/2;
        int pivot = array[middle];    //选一个数来作为基准，然后以这个数为基准，将小于他的数放到左边，大于他的数在右边
        int i=left,j=right;
        while(i<=j){
            while(array[i]<pivot)     //左边且小于的数，不动
                i++;
            while(array[j]>pivot)   //右边且大于的数，不动
                j--;
            if(i<=j){               //否则，交换位置，左边的大于基准的数和右边小于基准的数交换
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }
        }
        System.out.println(i+" "+j+" "+pivot);
        if(left<j)             //对左边的数再进行基准数左右分开
            quickSort(array,left,j);
        if(right>i)
            quickSort(array,i,right);//对右边的数再进行基准数左右分开
    }
}
