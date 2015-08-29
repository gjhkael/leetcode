package algorithm.leetcode;

/**
 * Created by havstack on 8/21/15.
 */
public class MySqrt {



    public int mySqrt(int x) {
        if(x<=1)return x;
        int result=0;
        int left=1;int right=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid<=x/mid){
                left=mid+1;
                result=mid;
            }else{
                right=mid-1;
            }

        }
        return result;
    }
}
