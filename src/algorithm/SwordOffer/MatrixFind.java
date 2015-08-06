package algorithm.SwordOffer;

/**
 * Created by kael on 8/2/15.
 */

//二维数组，行和列分别是安升序排列，查找特定的值
public class MatrixFind {
    public static void main(String[] args){
        int [][]test=new int[][]{{1,2,3},{2,4,6},{5,7,9}};
        System.out.println(matrixFind(test,8));

    }


    public static boolean matrixFind(int[][]array,int target){
        if(array.length==0||array==null)
            return false;
        int rows=0;
        int columns=array[0].length-1;
        while(rows<=(array.length-1)&&columns>=0){
            if(array[rows][columns]==target)
                return true;
            else if(array[rows][columns]<target)
                rows++;
            else
                columns--;

        }
        return false;
    }
}
