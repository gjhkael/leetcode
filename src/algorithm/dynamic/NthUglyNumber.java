package algorithm.dynamic;

/**
 * Created by havstack on 8/27/15.
 */
public class NthUglyNumber {



    public static int nthUglyNumber(int n){
        int []tmp=new int[n];
        tmp[0]=1;
        int index2=0,index3=0,index5=0;
        int factor2=2,factor3=3,factor5=5;
        for(int i=1;i<n;i++){
            int min=Math.min(Math.min(factor2,factor3),factor5);
            tmp[i]=min;
            if(min==factor2){
                factor2=2*tmp[++index2];
            }else if(min==factor3){
                factor3=3*tmp[++index3];
            }else{
                factor5=5*tmp[++index5];
            }
        }
        return tmp[n-1];
    }
}
