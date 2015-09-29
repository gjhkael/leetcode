package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hy on 2015/9/29.
 */
//字符串全排列的变形，这里给出第k个字符串

public class GetPermutation {

    public static void main(String[] args) { //给一个长为12的字符串，看其在字符串全排列中第几个位置
        Scanner scanner = new Scanner(System.in);
        long []f =new long [15];
        f[1] = 1;
        for(int i=2;i<=12;i++){
            f[i] = f[i-1]*i;
        }
        char []s = new char[15];
        int t = scanner.nextInt();
        while((t--)>0){
            String str = scanner.next();
            for(int i=0;i<str.length();i++){
                s[i+1] = str.charAt(i);
            }
            long sum =0;
            for(int i=1;i<=12;i++){
                int k=0;
                for(int j=i+1;j<=12;j++){
                    if(s[i]>s[j]) k++;
                }
                sum+=f[12 - i]*k;
            }
            System.out.println(sum+1);
        }
    }

    public String getPermutation(int n,int k){
        int pos = 0;
        List<Integer> numbers = new ArrayList<Integer>();
        int[] factorial = new int[n+1];
        int sum =1;
        factorial[0] = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sum*=i;
            factorial[i] = sum;
        }
        for(int i=1;i<n;i++){
            numbers.add(i);
        }
        k--;
        for(int i=1;i<=n;i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return  String.valueOf(sb);
    }

}
