package sort;

/**
 * Created by hy on 2015/7/25.
 */
public class MinHeap{
    private int [] data;
    public MinHeap(int []newdata){
        this.data=newdata;
        buildHeap();
    }
    public void buildHeap(){
        for(int i=data.length/2-1;i>=0;i--){
            heapify(i);
        }
    }
    public void heapify(int i){
        int l=2*i+1;
        int r=2*i+2;
        int minindex=i;
        if(l<data.length && data[l]<data[i])
            minindex=l;
        if(r<data.length && data[r]<data[minindex])
            minindex=r;
        if(minindex==i)
            return;
        else{
            int temp=data[i];
            data[i]=data[minindex];
            data[minindex]=temp;
            heapify(minindex);
        }
    }
    public int getRoot(){
        return data[0];
    }
    public void setRoot(int root){
        data[0]=root;
        heapify(0);
    }


}