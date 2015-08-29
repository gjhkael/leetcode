package algorithm.leetcode;

/**
 * Created by havstack on 8/21/15.
 */
public class AddDigits {

    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int result=0;
        while(num>=10){
            result+=num%10;
            num=num/10;
        }
        result+=num;
        return addDigits(result);
    }
}
