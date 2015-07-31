package leetcode;

/**
 * Created by hy on 2015/7/29.
 */
public class HammingWeight {
    public static void main(String[] args){
        HammingWeight hammingWeight=new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(-1));
    }
    public int hammingWeight(int n) {
        int result=0;
        while(n!=0){  //在java中没有无符号整数，当输入的是2147483648的时候，被认为是-1
            if((n&1)==1)
                result++;
            n=n>>>1;
        }
        return result;
    }

}
