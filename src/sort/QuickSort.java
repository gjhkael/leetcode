package sort;

import java.util.ArrayList;

/**
 * Created by hy on 2015/7/25.
 */
public class QuickSort {

    public static void quickSort(ArrayList<Integer> list,int left,int right){
        if(null==list || list.size()==0){
            return ;
        }
        if(left>=right){
            return ;
        }
        int middle = left+(right-left)/2;

        int pivot = list.get(middle);

        int i=left,j=right;
        while(i<=j){
            while(list.get(i)<pivot)
                i++;
            while(list.get(j)>pivot)
                j--;
            if(i<=j){
                int temp=list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
        System.out.println(i+" "+j+" "+pivot);
        if(left<j)
            quickSort(list,left,j);
        if(right>i)
            quickSort(list,i,right);
    }
}
