package sort;

/**
 * Created by gjh on 2015/7/25.
 */
public class MinHeap{
    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        ArrayUtils.printArray(data5);
        MinHeap minHeap=new MinHeap();
        minHeap.heapSort(data5);
        ArrayUtils.printArray(data5);
    }

    public void heapSort(int[] data){
        for(int i=0;i<data.length;i++){
            buildHeap(data,data.length-i);
            ArrayUtils.swap(data,0,data.length-i-1);
           // ArrayUtils.printArray(data); //可以打印变化过程
        }
    }

    public void buildHeap(int[] data,int length){
        for(int i=(length-1)/2;i>=0;i--){
            heapify(data,i,length);
        }
    }

    public void heapify(int[] data,int i,int length){
        int l=2*i+1;
        int r=2*i+2;
        int minIndex=i;
        if(l<length && data[l]<data[i])
            minIndex=l;
        if(r<length && data[r]<data[minIndex])
            minIndex=r;
        if(minIndex==i)
            return;
        else{
            int temp=data[i];
            data[i]=data[minIndex];
            data[minIndex]=temp;
            heapify(data,minIndex,length);
        }
    }
}