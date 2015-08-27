package algorithm.dynamic;

/**
 * Created by havstack on 7/1/15.
 */

//求数组的最大连续乘积子串

public class MaxProductSubstring {
    public static double maxProductSubString(double []input){  //暴力破解法
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

    public static double maxProduct(double[]input){ //动态规划算法，
        if(input.length==0||input==null){
            return 0;
        }
        double maxEnd=input[0];
        double minEnd=input[0];
        double maxResult=0;
        for(int i=1;i<input.length;i++){
            double end1=maxEnd*input[i];
            double end2=minEnd*input[i];
            maxEnd=Math.max(Math.max(end1,end2),input[i]);
            minEnd=Math.min(Math.min(end1,end2),input[i]);
            maxResult=Math.max(maxResult,maxEnd);
        }
        return maxResult;
    }


    public static void main(String[] args){
        double []test={ -2.5,4,0,3,0.5,8,-1};
        System.out.println(maxProduct(test));
    }
}
