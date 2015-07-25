package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author havstack
 * 求数组的topk问题
 */
public class TopK {
	//通过将数组的其余数和前k个数进行比较，小于或则大于的话进行交换。
	public static  List<Integer> topk(ArrayList<Integer>list,int k){
		if(list==null || list.size()<k){
			return null;
		}
		if(list.size()==k){
			return list;
		}
		for(int i=k;i<list.size();i++){
			for(int j=0;j<k;j++){
				if(list.get(i)<list.get(j)){
					int temp=list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list.subList(0, k);
	}
	
	//先将数组使用快速排序，然后取数组的前k个数据
	public static List<Integer> topk1(ArrayList<Integer>list, int k){
		if(list==null || list.size()<k){
			return null;
		}
		if(list.size()==k){
			return list;
		}
		quickSort(list,0,list.size()-1);
		return list.subList(0, k);
	}
	
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
	
	//快速选择算法
	public static void quickSelect(ArrayList<Integer> list,int left,int right,int k){
		if(list==null || list.size()==0)
			return;
		if(left>=right)
			return;
		int middle = left+(right-left)/2;
		int pivot = list.get(middle);
		int i=left,j=right;
		while(i<j){
			while(list.get(i)<pivot)
				i++;
			while(list.get(j)>pivot)
				j--;
			if(i<=j){
				int temp = list.get(i);
				list.set(i,list.get(j));
				list.set(j, temp);
				i++;
				j--;
			}
		}
		System.out.println(i+" "+j+" "+pivot);
		if(k<i){
			quickSelect(list,left,i-1,k);   //参数好难调
		}else if(k>i){
			quickSelect(list,i,right,k-i);
		}else{
			return ;
		}
		
	}
	
	

	private static int[] topK2(int[] data,int k)  
    {  
        // 先取K个元素放入一个数组topk中  
        int[] topk = new int[k];   
        for(int i = 0;i< k;i++)  
        {  
            topk[i] = data[i];  
        }  
          
        // 转换成最小堆  
        MinHeap heap = new MinHeap(topk);  
          
        // 从k开始，遍历data  
        for(int i= k;i<data.length;i++)  
        {  
            int root = heap.getRoot();  
              
            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆  
            if(data[i] > root)  
            {  
                heap.setRoot(data[i]);  
            }  
        }  
          
        return topk;  
}  
	
	
	
	

	public static void main(String[] args){
		ArrayList<Integer> test=new ArrayList<Integer>();
		for(int i=0;i<100;i++){
			test.add((int) ((Math.random())*100));
			//test.add(i);
		}
		
		for(Integer t:test){
			System.out.print(t+" ");
		}
		
		System.out.println();
		//test for topk
		/*List<Integer> result= TopK.topk(test, 2);
		for(Integer t:result){
			System.out.print(t+" ");
		}*/
		//test for quickSort
		/*List<Integer> result = TopK.topk1(test, 5);
		for(Integer t:result){
			System.out.print(t+" ");
		}*/
	    /*TopK.quickSelect(test, 0, 99,5);
		for(Integer t:test){
			System.out.print(t+" ");
		}*/
		int []t=new int[100];
		for(int i=0;i<=99;i++){
			t[i]=(int)(Math.random()*100);
			System.out.println(t[i]);
		}
		
		//MinHeap min=new MinHeap(t);
		
		int[] top=topK2(t,5);
		for(int i=0;i<5;i++){
			System.out.println(top[i]);
		}
		
		
		
		
		
	}
	
	
}


//首先构建一个k最大最小堆，然后不断替换这个堆
class MinHeap{
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
