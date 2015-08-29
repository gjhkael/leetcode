package algorithm.leetcode;

/**
 * Created by havstack on 8/21/15.
 */
public class PlusOne {
    public static void main(String[] args){
        int test[]={8,9,9,9};
        new PlusOne().plusOne(test);
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }


    public int[] plusOne(int[] digits) {
        digits[digits.length-1]+=1;
        for(int i=digits.length-1;i>0;i--)
        {
            if(digits[i]==10)
            {
                digits[i]=0;
                digits[i-1]+=1;
            }
        }
        if(digits[0]==10)
        {
            int[] res=new int[digits.length+1];
            digits[0]=0;
            res[0]=1;
            for(int i=1;i<res.length;i++)
            {
                res[i]=digits[i-1];
            }
            return res;
        }
        return digits;
    }
}
