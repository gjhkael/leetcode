package algorithm.SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/9/28.
 */
public class FindCountN41 {

    public static void main(String[] args){
        List<String>result = findCountN(9);
        for(String s:result){
            System.out.println(s);
        }
    }
    public static List<String> findCountN(int k){
        int small = 1,big =2;
        int middle = (1+k)/2;
        int curSum = small + big;
        List<String> result = new ArrayList<String>();
        while(small < middle){
            if(curSum==k){
                String str=count(small,big);
                result.add(str);
            }
            while(curSum>k && small<middle){
                curSum-=small;
                small++;
                if(curSum == k){
                    String str=count(small,big);
                    result.add(str);
                }
            }
            big++;
            curSum+=big;
        }
        return result;
    }
    public static String count(int start,int end){
        StringBuilder str = new StringBuilder("");
        for(int i=start;i<=end;i++){
            str.append(i);
        }
        return str.toString();
    }

}
