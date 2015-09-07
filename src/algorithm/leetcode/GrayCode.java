package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hy on 2015/9/7.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

    public ArrayList<Integer> grayCode1(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<n;i++){
            int inc = 1<<i;
            for(int j=arr.size()-1;j>=0;j--){
                arr.add(arr.get(j)+inc);
            }
        }
        return arr;
    }

    public static String[] grayCode2(int n){
        String[] grayCode=new String[(int)Math.pow(2,n)];
        if(n==1){
            grayCode[0]="0";
            grayCode[1]="1";
        }else{
            String[] last=grayCode2(n-1);
            for(int i=0;i<last.length;i++){
                grayCode[i]="0"+last[i];
                grayCode[grayCode.length-1-i]="1"+last[i];
            }
        }
        return grayCode;
    }
}
