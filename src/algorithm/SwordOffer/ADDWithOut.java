package algorithm.SwordOffer;

/**
 * Created by havstack on 9/7/15.
 */

//使用位运算来进行两个数的相加。不能使用加减乘除运算
public class ADDWithOut {

    public static void main(String[] args){
        System.out.println(add(12,34));
    }

    public static int add(int num1,int num2){
        int sum,carry;
        do{
            sum = num1^num2;
            carry = (num1&num2)<<1;
            num1=sum;
            num2=carry;
        }while(num2!=0);

        return num1;
    }


}
