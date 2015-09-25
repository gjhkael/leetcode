package algorithm.SwordOffer;

/**
 * Created by havstack on 8/27/15.
 */
public class Fibonacci09 {

    public static void main(String[] args){
        System.out.println(fibonacci(12));
        System.out.println(fibonacci2(12));
    }
    public static int fibonacci(int n){  //递归做法
        if(n==0||n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static int fibonacci2(int n){
        if(n<=1){
            return 1;
        }
        int num1=1,num2=1;
        for(int i=2;i<=n;i++){
            int tmp=num1;
            num1=num1+num2;
            num2=tmp;
        }
        return num1;
    }

}
