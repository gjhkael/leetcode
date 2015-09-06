package algorithm.sort;

/**
 * Created by hy on 2015/7/28.
 */
public class BinaryInsertSort{
    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        ArrayUtils.printArray(data5);
        binaryInsertSort(data5);
        ArrayUtils.printArray(data5);
    }

    public  static void binaryInsertSort(int[] data){
        for(int i=1;i<data.length;i++){
            int tmp=data[i];
            int low=0;
            int high=i-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(data[mid]<tmp)
                    low=mid+1;
                else
                    high=mid-1;
            }
            for(int j=i;j>low;j--){
                data[j]=data[j-1];
            }
            data[low]=tmp;
        }
    }

}
