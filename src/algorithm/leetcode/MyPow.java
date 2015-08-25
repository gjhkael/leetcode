package algorithm.leetcode;

/**
 * Created by havstack on 8/21/15.
 */
public class MyPow {

    public static void main(String[] args){
        System.out.println(new MyPow().myPow(8.88023,3));
    }
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            n=-n;
            x=1/x;
        }
        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);

    }
}











