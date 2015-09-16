package algorithm.DFSSearch;

/**
 * Created by hy on 2015/9/16.
 */
public class NQueues {
    static int count;   //记录多少种解法
    public static void main(String[] args) {
        int sequence[] = new int[8];                                     //记录第一行皇后列的位置。sequence[0]表示第0行皇后的列数
        eightQueue(sequence,0);
        System.out.println(count);
    }
    public static boolean isSafe(int rows,int columns,int[] sequence){  //判断rows和columns坐标位置是不是合法，从第0行往下遍历，依次查看历史位置和当前位置是不是冲突。
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

    public static void eightQueue(int[] sequence,int rows){
        int column;
        for(column =0;column<8;column++){
            if(isSafe(rows, column, sequence)){    //从0行 i列开始判断
                sequence[rows] = column;         //第rows行的值为column列
                if(rows==7){                     //如果是第八行了，那么肯定是完整的一个解法
                    count++;
                    for(int i=0;i<8;i++){
                        System.out.print(sequence[i]);
                    }
                    System.out.println();
                    sequence[rows] = 0;       //为了得到所有的解法将值赋值为0
                    return;
                }
                eightQueue(sequence, rows + 1);
                sequence[rows] = 0;
            }
        }
    }

}
