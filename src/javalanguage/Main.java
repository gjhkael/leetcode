package javalanguage;

import java.util.Scanner;

/**
 * Created by kael on 2015/9/18.
 */
public class Main {

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if(str.length()>=10){
                return;
            }
            char [] arr = new char[str.length()+1];
            for(int i=0;i<str.length();i++){
                arr[i] = str.charAt(i);
            }
            boolean result = true;
            for(int i=0;i<=str.length()/2;i++){
                for(int j=str.length()-1;j>=i;j--){
                    arr[j+1] = arr[j];
                }
                arr[i] = str.charAt(str.length()-1-i);
                for(int j=0;j<=arr.length/2;j++){
                    if(arr[j] != arr[str.length()-j]) {
                        result = false;
                        break;
                    }
                    if(j==arr.length/2){
                        result= true;
                    }
                }
                if(result){
                    break;
                }
                arr = new char[str.length()+1];
                for(int j=0;j<str.length();j++){
                    arr[j] = str.charAt(j);
                }

            }
            if(result){
                System.out.print("YES");
            }else{
                System.out.print("NO");
            }
    }

}