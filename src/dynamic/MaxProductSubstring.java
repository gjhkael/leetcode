package dynamic;

/**
 * Created by havstack on 7/1/15.
 */

//求数组的最大连续乘积子串

public class MaxProductSubstring {
    public static double maxProductSubString(double []input){
        double result=0;
        for(int i=0;i<input.length;i++){
            double tmp=1;
            for(int j=i;j<input.length;j++){
                tmp*=input[j];
                if(tmp>result){
                    result=tmp;
                }
            }
        }
        return result;
    }



    public static void main(String[] args){
        double []test={ -2.5,4,0,3,0.5,8,-1};
        System.out.println(maxProductSubString(test));
    }
}
