package structure.Backtracking;
import java.util.Stack;
/**
 * Created by kael on 2015/10/3.
 */
//迷宫找出路问题。
public class Maze {

    public static void main(String[] args){
        int[][] maze =
                {{1,1,1,1,1,1,1,1,1,1},
                {1,0,1,1,1,0,1,1,1,1},
                {1,1,0,1,0,1,1,1,1,1},
                {1,0,1,0,0,0,0,0,1,1},
                {1,0,1,1,1,0,1,1,1,1},
                {1,1,0,0,1,1,0,0,0,1},
                {1,0,1,1,0,0,1,1,0,1},
                {1,1,1,1,1,1,1,1,1,1}};
        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Stack<Step> s = new Stack<Step>();
        int a = path(maze, move, s);
        while(!s.isEmpty()){
            Step step = s.pop();
            System.out.println(step.x+":"+step.y);
        }


    }

    public static int path(int[][]maze,int [][]move,Stack<Step> s){
        Step temp = new Step(1,1,-1); //起点
        s.push(temp);
        while(!s.isEmpty()){
            Step cur = s.pop();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d+1;
            while(d<8){
                int i=x+move[d][0];
                int j=y+move[d][1];
                if(maze[i][j]==0){
                    cur = new Step(i,j,d);
                    s.push(cur);
                    x=i;
                    y=j;
                    maze[x][y] =-1;
                    if(x==6 && y==8){
                        return 1;
                    }else{
                        d=0;
                    }
                }else{
                    d++;
                }
            }
        }
        return 0;
    }
}

class Step{
    int x;
    int y;
    int d;
    public Step(int x,int y,int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
