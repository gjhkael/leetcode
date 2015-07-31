package leetcode;

/**
 * Created by hy on 2015/7/29.
 */
//求n！最后面0的个数
public class TrailingZeroes {
    public static void main(String[] args){
        System.out.println(trailingZeroes(30));

    }

    public static long trailingZeroes(long n) {
        int rs = 0;
        while (n != 0) {
            rs += (n / 5);
            n /= 5;
        }
        return rs;
    }

}
