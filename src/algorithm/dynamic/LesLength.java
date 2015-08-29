package algorithm.dynamic;

/**
 * Created by kael on 8/2/15.
 */
public class LesLength {


    public static void main(String[] args){
        char[]x=new char[]{'a','b','d'};
        char[]y=new char[]{'b','d'};
        int[][]b=new int[2][2];

        System.out.println(lesLength(x, y, b));
    }

    public static int lesLength(char[] x,char[]y,int[][]b){  //求最长公共子序列，注意和最长公共子字符串的区别
        if(x.length==0||y.length==0||x==null||y==null)
            return 0;
        int xLength=x.length;
        int yLength=y.length;
        int[][]result=new int[x.length+1][y.length+1];
        for(int i=1;i<=xLength;i++){
            for(int j=1;j<=yLength;j++){
                if(x[i-1]==y[j-1])
                    result[i][j]=result[i-1][j-1]+1;
                else if(result[i-1][j]<result[i][j-1])
                    result[i][j]=result[i][j-1];
                else
                    result[i][j]=result[i-1][j];
            }
        }
        return result[xLength][yLength];
    }
}
