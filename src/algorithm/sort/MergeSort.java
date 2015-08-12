package algorithm.sort;

/**
 * Created by gjh on 2015/7/25.
 */
//利用分治思想，写的归并排序
public class MergeSort {
    public static void main(String[] args){
        int[] test={2,5,3,1,6,8,7,10,9};
        ArrayUtils.printArray(test);
        mergeSort(test,0,test.length-1);
        ArrayUtils.printArray(test);
    }
    public static void mergeSort(int[] array,int left,int right){
        if(array.length==0 || array==null)
            return ;
        if(left>=right) return;
        int center=left+(right-left)/2;
        mergeSort(array,left,center);    //递归排序左半部分数据
        mergeSort(array,center+1,right); //递归排序右半部分数据
        merge(array,left,center,right);  //合并数据
    }
    public static void merge(int[] array,int left,int center,int right){
        int[] tmp=new int[array.length];    //用来存中间结果
        int mid=center+1;   //利用while循环从开头和中间将较小的数据存在临时数组的最开始
        int index=left;     //记录left位置
        int tmpIndex=left;
        while(left<=center&&mid<=right){
            if(array[left]<array[mid])     //将较小的数据存放到临时数组中
                tmp[tmpIndex++]=array[left++];
            else
                tmp[tmpIndex++]=array[mid++];
        }
        while(left<=center){
            tmp[tmpIndex++]=array[left++];
        }
        while(mid<=right){
            tmp[tmpIndex++]=array[mid++];
        }
        while(index<=right){
            array[index]=tmp[index];
            index++;
        }
    }


}
