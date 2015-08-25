package algorithm.leetcode;

/**
 * Created by havstack on 8/21/15.
 */
public class NthUglyNumber {


    public int nthUglyNumber(int n) {
        int []ugly=new int[n];
        int index2=0,index3=0,index5=0;
        int factor2=2,factor3=3,factor5=5;
        ugly[0]=1;
        for(int i=1;i<n;i++){
            int min=Math.min(Math.min(factor2,factor3),factor5);  //每次把最小的数存入到数组，同时更新factors
            ugly[i]=min;
            if(factor2==min){
                factor2=2*ugly[++index2];                //因为 2 3 5 都是需要从1 2 3 4 5.。。不断相乘
            }
            if(factor3==min){
                factor3=3*ugly[++index3];
            }
            if(factor5==min){
                factor5=5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }

}
