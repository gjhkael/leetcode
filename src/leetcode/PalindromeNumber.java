package leetcode;

/**
 * Created by havstack on 7/22/15.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int n=1;
        if(x<0)
            return false;
        if(x<10)
            return true;
        while(x/n>=10){
            n*=10;
        }
        while(x>0){
            //System.out.println(x+" "+n);
            if(x/n!=x%10) return false;
            x=x%n;
            if(x<10) return true;
            x=x/10;
            n=n/100;
        }
        return true;
    }


    public static void main(String[] args){

    }
}
