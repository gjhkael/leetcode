package javalanguage;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by hy on 2015/8/6.
 */
public class test {
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


    public static   int houseRobber2(int[] nums){
        if(nums.length==0||nums==null)
            return 0;
        int preYes=0;
        int preNo=0;
        for(int i=0;i<nums.length;i++){
            int tmp=preNo;
            preNo=Math.max(preYes,preNo);
//            if(nums[i]<0){
//                preYes=tmp;
//            }else {
            preYes = tmp + nums[i];
            //}
        }
        return Math.max(preYes,preNo);
    }

    public static void splits() {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            String[] split = in.split(" ");
            sc.next();
            System.out.println(split[split.length-1].length());
    }


    public static void ssss(){

            int n=0,m=0;
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
                n = scan.nextInt();
                m = scan.nextInt();
                if(n <= 0 || n >= 30000 || m <= 0 || m >= 5000){
                    System.out.println("Error Input !");
                    break;
                }
                int[] studentScore = new int[n];
                for(int i = 0; i<n; i++){
                    studentScore[i] = scan.nextInt();
                }

                for(int i = 0; i<m; i++){
                    String tmp = scan.next();
                    if(tmp.equals("U")){
                        int n1 = scan.nextInt();
                        int n2 = scan.nextInt();
                        studentScore[n1-1] = n2;

                    }else if(tmp.equals("Q")){
                        int n1 = scan.nextInt();
                        int n2 = scan.nextInt();
                        if(n1 < 0)
                            n1 =1;
                        if(n2 >= n){
                            n2 = n;
                        }
                        if( n2< n1){
                            int tmps =n1;
                            n1 = n2;
                            n2 = tmps;
                        }
                        int max = 0;
                        for(int j = n1-1; j <= n2-1; j++){
                            if(studentScore[j]>max)
                                max = studentScore[j];
                        }
                        System.out.println(max);
                    }
                }
        }
    }

}
