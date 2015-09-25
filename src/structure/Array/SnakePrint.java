package structure.Array;

import java.util.Scanner;

/**
 * Created by hy on 2015/9/25.
 */
//蛇形填数，在n*n方阵中填入1,2，。。。，n*n
public class SnakePrint {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][]tmp = new int[n][n];
        int index = 1;
        int row =0;int column = n-1;
        tmp[row][column] = 1;//从右上角开始打印1，然后往下打印，接着往左，最后往上

        while(index<n*n){
            while(row+1<n && tmp[row+1][column]==0){      //从上往下赋值
                tmp[++row][column] = ++index;
            }
            while(column-1>=0 && tmp[row][column-1]==0){  //从右往左赋值
                tmp[row][--column] = ++index;
            }
            while(row-1>=0 && tmp[row-1][column]==0){    //从下往上赋值
                tmp[--row][column] = ++index;
            }
            while(column+1 <n&& tmp[row][column+1]==0){  //从左往右赋值
                tmp[row][++column] = ++index;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
