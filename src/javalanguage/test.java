package javalanguage;

import java.util.*;

/**
 * Created by hy on 2015/8/6.
 */
public class test {
    public static void main(String[] args) {
        int sequence[] = new int[8];
        eightQueue(sequence,0);
        System.out.println(count);
    }
    public static boolean isSafe(int rows,int columns,int[] sequence){
        for(int i=0;i<rows;i++){
            int col = sequence[i];
            if(col == columns){
                return false;
            }
            if((rows+columns)==(i+col)||(rows-columns)==(i-col)){
                return false;
            }
        }
        return true;
    }
    static int count;
    public static void eightQueue(int[] sequence,int rows){
        int column;
        for(column =0;column<8;column++){
            if(isSafe(rows,column,sequence)){
                sequence[rows] = column;
                if(rows==7){
                    count++;
                    for(int i=0;i<8;i++){
                        System.out.print(sequence[i]);
                    }
                    System.out.println();
                    sequence[rows] = 0;
                    return;
                }
                eightQueue(sequence,rows+1);
                sequence[rows] = 0;
            }
        }
    }


}
