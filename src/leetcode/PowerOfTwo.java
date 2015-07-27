package leetcode;

/**
 * Created by gjh on 2015/7/27.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        int ones=0;
        while(n>0){
            if((n&1)==1)
                ones++;
            n=n>>1;
        }
        if(ones>1)
            return false;
        else
            return true;
    }
}
