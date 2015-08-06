package algorithm.sort;

/**
 * Created by hy on 2015/7/28.
 */
//桶排序，先计算每个数出现的频率，然后从小到大进行排序，这种适合数据量大，但是最大值和最小值相差不大的情况
public class BucketSort {
    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 ,4,5,7,8};
        ArrayUtils.printArray(data5);
        bucketSort(data5,1,10);
        ArrayUtils.printArray(data5);
    }
    public static void bucketSort(int[] data, int min, int max) {
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[max - min];
        // 计算每个元素在序列出现的次数
        for (int i = 0; i < data.length; i++) {
            buckets[data[i] - min]++;
        }
        int index=0;
        for(int i=0;i<max-min;i++){
            for(int j=0;j<buckets[i];j++){
                System.out.println(i+min);
                data[index++]=i+min;
            }
        }
    }
}
