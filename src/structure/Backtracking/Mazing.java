package structure.Backtracking;

import java.util.Stack;

/**
 * Created by kael on 2015/10/6.
 */
//�ƶ��Թ�����
public class Mazing {


    public static void main(String[] args){
        int[][] maze =
                {       {1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,1,1,0,1,1,1,1},
                        {1,1,0,1,0,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,1,1},
                        {1,0,1,1,1,0,0,1,1,1},
                        {1,1,0,0,1,1,0,0,1,1},
                        {1,0,1,1,0,0,1,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1}   };
        Stack<Position> stack = new Stack<Position>();
        boolean[][]visited = new boolean[maze.length][maze[0].length];
        findPath(maze,stack,visited);

    }

    public static void findPath(int[][]maze,Stack<Position> stack,boolean [][]visited){
        int i=1;
        int j=1;
        visited[i][j] = true;
        stack.push(new Position(i,j));
        while(!stack.isEmpty() && (!(i==(maze.length-2)||j==(maze[0].length-2)))){
            if(maze[i][j+1]==0 && visited[i][j+1]==false){
                visited[i][j+1]=true;
                stack.push(new Position(i,j+1));
                j++;
            }else if(maze[i+1][j]==0 && visited[i+1][j]==false){
                visited[i+1][j] = true;
                stack.push(new Position(i+1,j));
                i++;
            }else if(maze[i-1][j]==0 && visited[i-1][j]==false){
                visited[i-1][j]=true;
                stack.push(new Position(i-1,j));
                i--;
            }else if(maze[i][j-1]==0 && visited[i][j-1]==false){
                visited[i][j-1] =true;
                stack.push(new Position(i,j-1));
                j--;
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                i=stack.peek().x;
                j=stack.peek().y;
            }
        }
        Stack<Position> newPos = new Stack<Position>();
        if(stack.isEmpty()){
            System.out.println("无路径");
        }else{
            System.out.println("有路径");
            while (!stack.empty()) {
                Position pos = stack.pop();
                newPos.push(pos);
            }
        }


        String resault[][]=new String[maze.length][maze[0].length];
        for(int k=0;k<maze.length;++k){
            for(int t=0;t<maze[0].length;++t){
                resault[k][t]=(maze[k][t])+"";
            }
        }

        while (!newPos.empty()) {
            Position p1=newPos.pop();
            resault[p1.x][p1.y]="#";
        }

        for(int k=0;k<maze.length;++k){
            for(int t=0;t<maze[0].length;++t){
                System.out.print(resault[k][t]+"\t");
            }
            System.out.println();
        }
    }
}

class Position{
    int x;
    int y;
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
}
