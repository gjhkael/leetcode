package structure.Backtracking;

/**
 * Created by hy on 2015/9/25.
 */
public class test {

    public static void main(String[] args){
        int[][]maze={{0,0},{0,0}};
        if(maze[1][1]==0){
            System.out.println(maze[1][1]);
        }else if(maze[1][0]==0){
            System.out.println(maze[1][1]);
        }else if(maze[0][0]==0){
            System.out.println(maze[1][1]);
        }

    }
}
