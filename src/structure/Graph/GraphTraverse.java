package structure.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by hy on 2015/9/16.
 */
public class GraphTraverse {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        char[]node = new char[n];
        int[][]table = new int[n][n];
        for(int i=0;i<str.length();i++){
            node[i]=str.charAt(i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                table[i][j] = scanner.nextInt();
            }
        }
        BFSTraverse(table, node, n);
    }

    public static void DFSTraverse(int[][] table,char[]node,int n){
        boolean isVisited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(isVisited[i] ==false){   //这里需要注意，
                DFS(table,node,isVisited,i,n);
            }
        }
    }

    public static void DFS(int[][]table,char[] node,boolean[]isVisited,int cur,int n){
        isVisited[cur]=true;
        System.out.print(node[cur]);
        for(int j=0;j<n;j++){
            if(isVisited[j]==false && table[cur][j]==1){
                DFS(table,node,isVisited,j,n);
            }
        }
    }

    public static void BFSTraverse(int[][]table,char[] node, int n){
        boolean []isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(isVisited[i]==false){
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(i);
                while(!queue.isEmpty()){
                    int j = queue.poll();
                    System.out.print(node[j]);
                    isVisited[j] = true;
                    for(int k =0;k<n;k++){
                        if(table[j][k]==1 && isVisited[k]==false){
                            queue.add(k);
                        }
                    }
                }
            }
        }
        System.out.println();
    }

}
