package sort;

/**
 * Created by gjh on 2015/7/28.
 */
public class ShellSort {
    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 ,4,5,7,8};
        ArrayUtils.printArray(data5);
        shellSort(data5);
        ArrayUtils.printArray(data5);
    }
    public static void shellSort(int[] data){
        int h=1;
        while(h<=data.length/3){
            h=h*3+1;
        }
        while(h>0){
            System.out.println(h);
            for(int i=h;i<data.length;i++){
                if (data[i] < data[i - h]) {
                    int tmp = data[i];
                    int j = i - h;
                    while (j >= 0 && data[j] > tmp) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = tmp;
                }
            }
            ArrayUtils.printArray(data);
            h=(h-1)/3;
        }
    }
}
