package algorithm.SwordOffer;

/**
 * Created by kael on 9/5/15.
 */
public class PrintMatrixClockWisely {


    public static void printMatrixClockWisely(int[][] nums){
        if(nums == null)
            return;
        int rows = nums.length;
        int columns = nums[0].length;
        int start=0;
        while(columns > start*2 && rows > start*2){
            printMatrix(nums,rows,columns,start);
            start++;
        }
    }

    public static void printMatrix(int[][]nums,int rows,int columns,int start){
        int endX = columns-1-start;
        int endY = rows-1-start;
        //从左到右打印
        for(int i=start;i<=endX;i++)
            System.out.print(nums[start][i]);
        //从上往下打印
        if(start < endY){
            for(int i = start +1;i<=endY;i++){
                System.out.print(nums[i][endX]);
            }
        }
        //从右往左打印
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;i--){
                System.out.print(nums[endY][i]);
            }
        }
        //从下往上打印
        if(start<endX && start<endY-1){
            for(int i=endY-1;i>=start+1;--i){
                System.out.println(nums[i][start]);
            }

        }
    }
}
