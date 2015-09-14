package algorithm.huaweiOj;

import java.util.Scanner;

/**
 * Created by hy on 2015/9/14.
 */
public class CountWithSeven {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n<7||n>=30000)
            System.out.println(0);
        int result =0;
        for(int i=7;i<n;i++){
            if(i%7==0)
                result++;
            else{
                String s = String.valueOf(i);
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)=='7') {
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
