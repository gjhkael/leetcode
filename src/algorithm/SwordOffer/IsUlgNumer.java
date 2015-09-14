package algorithm.SwordOffer;

/**
 * Created by havstack on 8/21/15.
 */
public class IsUlgNumer {

    public static void main(String[] args){

    }
    public boolean isUgly(int num) {
        if(num<1)
           return false;
        if(num==1)
            return true;
        if(num%2==0){num/=2;return isUgly(num);}
        else if(num%3==0){num/=3;return isUgly(num);}
        else if(num%5==0){num/=5;return isUgly(num);}
        else
            return false;
    }
}
