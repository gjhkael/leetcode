package algorithm.huaweiOj;

import java.util.Scanner;

/**
 * Created by hy on 2015/9/12.
 */
public class ImageProcess {

    public static void main(String[] args){
        int [] tmp = new int[63];
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        for(int i=0;i<s.length();i++){
            char num = s.charAt(i);
            if(num-'0'>=0 && num-'0'<10)tmp[num-'0']++;
            if(num-'A'>=0 && num-'A'<=26)tmp[num-'A'+10]++;
            if(num-'a'>=0 && num-'a'<=26)tmp[num-'a'+36]++;
        }
        for(int i=0;i<63;i++){
            for(int j=0;j<tmp[i];j++){
                if(i>=36){
                    System.out.print((char)(i-36+'a'));
                }else if(i>=10){
                    System.out.print((char)(i-10+'A'));
                }else {
                    System.out.print((char)(i+'0'));
                }
            }
        }
        System.out.println("");
    }
}
