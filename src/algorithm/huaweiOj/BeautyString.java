package algorithm.huaweiOj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hy on 2015/9/14.
 */
public class BeautyString {
    public static void main(String[] args){
        int n=0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i]=scan.next();
        }
        for(int i=0;i<n;i++){
            //System.out.print(coutBeauty(str[i])+" ");//真恶心，这里输出要换行
            System.out.println(coutBeauty(str[i]));
        }

    }
    public static int coutBeauty(String s){
        int result =0;int tmp=26;
        int [] fax = new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'a'>=0 && s.charAt(i)-'a'<26){
                fax[s.charAt(i)-'a']++;
            }
            if(s.charAt(i)-'A'>=0 && s.charAt(i)-'A'<26){
                fax[s.charAt(i)-'A']++;
            }
        }
        Arrays.sort(fax);

        for(int i=fax.length-1;i>=0;i--){
            result+=tmp*fax[i];
            tmp--;
        }
        return result;
    }
}
