package algorithm.leetcode;

/**
 * Created by havstack on 7/13/15.
 */
/*
  将整数进行反转
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int result=0;
        if(x==0){
            return 0;
        }else if(x>0){
            while(x/10>0){
                result = result*10+x%10;
                x=x/10;
            }
            if(result<=(Integer.MAX_VALUE/10)&&(x%10<Integer.MAX_VALUE-result*10)) {
                result = result * 10 + x % 10;
            }else{
                return 0;
            }
        }else{
            if(x==Integer.MIN_VALUE){
                return 0;
            }
            int y=(-1)*x;
            while(y/10>0){
                result=result*10+y%10;
                y=y/10;
            }
            if(result<=(Integer.MAX_VALUE/10)&&(x%10<Integer.MAX_VALUE-result*10)) {
                result = result * 10 + y % 10;
            }else{
                return 0;
            }
            result=result*(-1);
        }
        return  result;
    }
    public static void main(String[] args){
        System.out.println(reverse(-2147483412));
    }
}
