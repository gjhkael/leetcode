package algorithm.dynamic;

/**
 * Created by hy on 2015/9/10.
 */
public class UniquePathWithObstacles {

    public static void main(String[] args){
        int[][]test ={{1,0}};
        System.out.println(uniquePathsWithObstacles(test));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return 0;
        int lows=obstacleGrid.length;
        int columns=obstacleGrid[0].length;
        int [][]tmp=new int[lows][columns];

        for(int i=0;i<lows;i++){
            if(obstacleGrid[i][0]==1){   //如果为1的话，接下来所有的数都应该为0
                break;
            }else{
                tmp[i][0]=1;
            }
        }
        for(int i=0;i<columns;i++){
            if(obstacleGrid[0][i]==1) { //如果为1的话，接下来所有的数都应该为0
                break;
            }else{
                tmp[0][i] = 1;
            }
        }

        for(int i=1;i<lows;i++){
            for(int j=1;j<columns;j++){
                if(obstacleGrid[i][j]==1){  //如果为1的话，该位置为0
                    tmp[i][j]=0;
                }else{
                    tmp[i][j]=tmp[i-1][j]+tmp[i][j-1]; //否则就是左边的数加上上面的数
                }
            }
        }
        return tmp[lows-1][columns-1];

    }
}
