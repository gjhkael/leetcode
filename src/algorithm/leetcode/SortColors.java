package algorithm.leetcode;

/**
 * Created by hy on 2015/8/13.
 */
public class SortColors {
    public static void main(String[] args){
        int []test={2,0, 1};
        sortColors(test);
        for(int s:test){
            System.out.println(s);
        }

        Object o=new Object(){
          public boolean equals(Object obj){
              return true;
          }
        };
        System.out.println(o.equals("fa"));



    }
    public static void sortColors(int[] nums) {
        if(nums.length<=1)
            return ;
        int left=0;int right=nums.length-1;
        for(int i=left;i<=right;i++){
            while(nums[i]==2&&i<right){
                swap(nums,i,right);
                right--;
            }
            while(nums[i]==0&&i>=left){
                swap(nums,i,left);
                left++;
            }
        }
    }
    public static void swap(int[] nums,int s1,int s2){
        int tmp=nums[s1];
        nums[s1]=nums[s2];
        nums[s2]=tmp;
    }
}
