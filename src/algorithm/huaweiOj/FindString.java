package algorithm.huaweiOj;

import java.util.Scanner;

/**
 * Created by hy on 2015/9/16.
 */
public class FindString {
    public static boolean dep(char[][]str,int a,int b,String s ){
        if(s.equals(""))
            return true;
        if(a<0 || b<0 || a>=str.length || b>=str[0].length) {
            return false;
        }
        if(str[a][b]==s.charAt(0)){
            if(dep(str,a-1,b,s.substring(1))||dep(str,a+1,b,s.substring(1))||dep(str,a,b-1,s.substring(1))||dep(str,a,b+1,s.substring(1))){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        char[][] str = new char[rows][columns];
        String s = scan.next();
        for(int i=0;i<rows;i++){
            String tmp = scan.next();
            for(int j=0;j<columns;j++) {
                str[i][j] = tmp.charAt(j);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++) {
                boolean result = dep(str, i, j, s);
                if(result) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}
