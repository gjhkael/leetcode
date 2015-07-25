package leetcode;

/**
<<<<<<< HEAD
 * Created by hy on 2015/7/21.
 */
public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println(isPalindrome(1001));
    }
    public static boolean isPalindrome(int x) {
=======
 * Created by havstack on 7/22/15.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
>>>>>>> 0dcfbfed05474c6de0c3f3303aadf243efe42f54
        int n=1;
        if(x<0)
            return false;
        if(x<10)
            return true;
        while(x/n>=10){
            n*=10;
        }
        while(x>0){
<<<<<<< HEAD
            System.out.println(x+" "+n);
=======
            //System.out.println(x+" "+n);
>>>>>>> 0dcfbfed05474c6de0c3f3303aadf243efe42f54
            if(x/n!=x%10) return false;
            x=x%n;
            if(x<10) return true;
            x=x/10;
            n=n/100;
        }
        return true;
    }
<<<<<<< HEAD
=======


    public static void main(String[] args){

    }
>>>>>>> 0dcfbfed05474c6de0c3f3303aadf243efe42f54
}
