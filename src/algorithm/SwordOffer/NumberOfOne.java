package algorithm.SwordOffer;

/**
 * Created by havstack on 8/27/15.
 */
public class NumberOfOne {
    public static void main(String[] args){

        System.out.println(numberOf2(-1));
    }

    public static int numberOf1(int n){//利用移位计算
        int flag=1;
        int count=0;
        while(flag>0){
            if((flag & n)>0)
                count++;
            flag<<=1;
        }
        return count;
    }
    public static int numberOf2(int n){ //利用数n减去-和n相与后少一个1
        int count=0;
        while(n!=0){        //这里需要注意，如果要计算负数的情况，这里需要把n设置为不等于0
            count++;
            n=n&(n-1);
        }
        return count;
    }

}
