package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by hy on 2015/7/29.
 */
//基数排序
public class MultikeyRadixSortTest {
    public static void main(String[] args) {
        int[] data = new int[] { 1100, 192, 221, 12, 23 };
        ArrayUtils.printArray(data);
        //radixSort(data, 10, 4);
        radixSortSample(data,10,4);
        System.out.println("排序后的数组：");
        ArrayUtils.printArray(data);


    }

    public static void radixSort(int[] data, int radix, int d) {
        // 缓存数组
        int[] tmp = new int[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        for (int i = 0, rate = 1; i < d; i++) {
            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmp, 0, data.length);
            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }
            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }
            // 按子关键字对指定的数据进行排序
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % radix;
                data[--buckets[subKey]] = tmp[m];
            }
            rate *= radix;
        }

    }

    public static void radixSortSample(int []array,int radix,int d){
        if(array==null||array.length==0)
            return;
        ArrayList<ArrayList<Integer>>lists=new ArrayList<ArrayList<Integer>>(radix);  //首先建立一个10个长度的数组，数组里用来存放数组，
        for(int i=0;i<radix;i++){
            lists.add(new ArrayList());
        }
        for(int j=0;j<d;j++) {                          //进行d次排序
            for (int i = 0; i < array.length; i++) {   //每个基数进行一次n排序
                int tmp = array[i] %(int)Math.pow(10,j+1)/(int)Math.pow(10,j);
                lists.get(tmp).add(array[i]);
            }
            int count=0;
            for(int i=0;i<radix;i++){      //重新将数组元素赋值到原数组
                for(int k=0;k<lists.get(i).size();k++){
                    array[count++]= lists.get(i).get(k);
                }
                lists.get(i).clear();    //这里需要清空数组，否则容易出错
            }

        }
    }



}