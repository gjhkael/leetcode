package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/8/15.
 */
public class MergeIntervals {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String[] args){
        List<Interval> list=new ArrayList<Interval>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        List<Interval> result=merge(list);
        for(Interval s: result){
            System.out.println(s.start);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<Interval>();

        quickSort(intervals,0,intervals.size()-1);
        for(int i=0;i<intervals.size()-1;i++){
            if(intervals.get(i).end>intervals.get(i+1).end){
                intervals.set(i+1,intervals.get(i));
            }else if(intervals.get(i).end>intervals.get(i+1).start){
                intervals.get(i + 1).start=intervals.get(i).start;
            }else{
                result.add(intervals.get(i));
            }
        }
        result.add(intervals.get(intervals.size()-1));
        return result;
    }
    public static void quickSort(List<Interval> intervals,int left,int right){
        if(null==intervals || intervals.size()==0){
            return ;
        }
        if(left>=right){
            return ;
        }
        int middle = left+(right-left)/2;
        int pivot = intervals.get(middle).start;    //选一个数来作为基准，然后以这个数为基准，将小于他的数放到左边，大于他的数在右边
        int i=left,j=right;
        while(i<=j){
            while(intervals.get(i).start<pivot)     //左边且小于的数，不动
                i++;
            while(intervals.get(j).start>pivot)   //右边且大于的数，不动
                j--;
            if(i<=j){               //否则，交换位置，左边的大于基准的数和右边小于基准的数交换
                Interval temp=intervals.get(i);
                intervals.set(i, intervals.get(j));
                intervals.set(j,temp);
                i++;
                j--;
            }
        }
        System.out.println(i+" "+j+" "+pivot);
        if(left<j)             //对左边的数再进行基准数左右分开
            quickSort(intervals,left,j);
        if(right>i)
            quickSort(intervals,i,right);//对右边的数再进行基准数左右分开
    }
}
