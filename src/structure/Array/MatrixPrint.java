package structure.Array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by hy on 2015/9/25.
 */
//从外圈开始以顺时针的方式打印数组

public class MatrixPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int tmp [][] = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                tmp[i][j] = scanner.nextInt();
            }
        }
        int start =0;
        while(2*start<row && 2*start<column){   //这里有两点需要注意 1：初始值为start，这停止条件是2*start<row && 2*start<column
            printMatrix(tmp,start);
            start++;
        }
    }

    public static void printMatrix(int[][]nums,int start){  //简单的打印一个四边形
        int rows = nums.length;
        int columns = nums[0].length;
        int endX = rows -1 - start;     //打印的停止行数
        int endY = columns -1 -start;   //打印的停止列数
        for(int i=start;i<=endY;i++){
            System.out.print(nums[start][i]+" ");
        }
        for(int i=start+1;i<=endX;i++){
            System.out.print(nums[i][endY]+" ");
        }
        for(int i=endY-1;i>=start;i--){
            System.out.print(nums[endX][i]+" ");
        }
        for(int i=endX-1;i>start;i--){
            System.out.print(nums[i][start]+" ");
        }
    }
}
