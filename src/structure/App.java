package structure;

import java.util.Scanner;

/**
 * Created by hy on 2015/9/25.
 */
public class App {

    public static void main(String[] args){
        int[]nums = new int[1000];
        Scanner scanner = new Scanner(System.in);
        int index=0;
        while(true){
            if(scanner.next().equals("")){
                break;
            }
            nums[index++] = scanner.nextInt();

        }
        int []test =new int[index];
        for(int i=0;i<index;i++){
            test[i] = nums[i];
        }
        max(test);
    }

    public static void max(int[] nums){
        if(nums ==null || nums.length==0){
            return;
        }
        //int dp[][] = new int[nums.length][nums.length];
        int start=0;int end =0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for(int j=0;j<nums.length;j++){
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                if(sum==0){
                    if(j-i>max){
                        max=j-i;
                        start = i;
                        end = j;
                    }
                }
                sum =0;
            }
        }

        if(start==0 && end ==0){
            return;
        }
        for(int i=start;i<=end;i++){
            System.out.print(nums[i]);
        }
    }

}
