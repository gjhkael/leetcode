package algorithm.sort;

/**
 * Created by hy on 2015/7/25.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        ArrayUtils.printArray(data5);
        quicksort(data5,0,8);
        ArrayUtils.printArray(data5);
    }

    public static void quickSort(int[] array,int left,int right){
        if(null==array || array.length==0){
            return ;
        }
        if(left>=right){
            return ;
        }
        int middle = left+(right-left)/2;
        int pivot = array[middle];    //选一个数来作为基准，然后以这个数为基准，将小于他的数放到左边，大于他的数在右边
        int i=left,j=right;
        while(i<=j){
            while(array[i]<pivot)     //左边且小于的数，不动
                i++;
            while(array[j]>pivot)   //右边且大于的数，不动
                j--;
            if(i<=j){               //否则，交换位置，左边的大于基准的数和右边小于基准的数交换
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }
        }
        System.out.println(i+" "+j+" "+pivot);
        if(left<j)             //对左边的数再进行基准数左右分开
            quickSort(array,left,j);
        if(right>i)
            quickSort(array,i,right);//对右边的数再进行基准数左右分开
    }


//    public static void quicksort(int n[], int left, int right) {
//        int dp;
//        if (left < right) {
//            dp = partition(n, left, right);
//            quicksort(n, left, dp - 1);
//            quicksort(n, dp + 1, right);
//        }
//    }
//
//    public static int partition(int n[], int left, int right) {
//        int pivot = n[left];
//        while (left < right) {
//            while (left < right && n[right] >= pivot)
//                right--;
//            if (left < right)
//                n[left++] = n[right];
//            while (left < right && n[left] <= pivot)
//                left++;
//            if (left < right)
//                n[right--] = n[left];
//        }
//        n[left] = pivot;
//        return left;
//    }

    public static void quicksort(int[] nums,int left,int right){
        int dp;
        if(left<right){
            dp=partition(nums,left,right);
            quickSort(nums,left,dp-1);
            quickSort(nums,dp+1,right);
        }
    }

    public static int partition(int[] nums,int left, int right){
        int pivot=nums[left];
        while(left<right){
            while(left<right&& nums[right]>=pivot){
                right--;
            }
            if(left<right){
                nums[left++]=nums[right];
            }
            while(left<right&&nums[left]<pivot){
                left++;
            }
            if(left<right){
                nums[right--]=nums[left];
            }
        }
        nums[left]=pivot;
        return left;
    }




}
