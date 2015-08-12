package algorithm.leetcode;

/**
 * Created by hy on 2015/7/29.
 */
public class ReverseBits {
    public static void main(String[] args){
        ReverseBits reverseBits=new ReverseBits();
        System.out.println(reverseBits.reverseBits(10));
    }
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            result=result<<1;
            if((n&1)==1)
                result+=1;
            n=n>>1;
            //System.out.println(Integer.toBinaryString(result));
        }
        return result;
    }
}
