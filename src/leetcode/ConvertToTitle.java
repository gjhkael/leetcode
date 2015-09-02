package leetcode;

/**
 * Created by kael on 8/9/15.
 */
public class ConvertToTitle {

    public static void main(String[] args){
        System.out.println(convertToTitle(25));
    }

    public static String convertToTitle(int n) {
        if(n<=0)
            return null;
        StringBuilder result=new StringBuilder("");
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
