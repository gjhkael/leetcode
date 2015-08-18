package algorithm.leetcode;

/**
 * Created by hy on 2015/8/11.
 */
public class TrappingRainWater {
    public static void main(String[] args){
        int[]test={4,2,3};
        System.out.println(trap(test));

    }


    public static int trap(int[] height) {
        if(height.length<3)
            return 0;
        int l=0;
        int r=height.length-1;
        int result=0;
        //去除不合法的边界
        while(l<r&& height[l]<height[l+1])l++;
        while(l<r&& height[r]<height[r-1])r--;
        while(l<r){
            int left=height[l];
            int right=height[r];
            System.out.println(left+" "+right);
            if(left<right){
                while(l<r&&left>=height[++l]){
                    result+=(left-height[l]);
                }
            }else{
                while(l<r&&right>=height[--r]){

                    result+=(right-height[r]);
                }

            }
        }
        return result;


    }
}
