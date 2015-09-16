package algorithm.huaweiOj;

import java.util.Scanner;

/**
 * Created by hy on 2015/9/16.
 */
public class FindH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int columns = scanner.nextInt();
        char [][]table = new char[num][columns];
        int Brows=0; int Bcloumns =0;
        for(int i=0;i<num;i++){
            String str = scanner.next();
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='H'){
                    Brows = i;
                    Bcloumns = j;
                }
                table[i][j] = str.charAt(j);
            }
        }
        boolean [][]isVisited = new boolean[num][columns];
        boolean result = DFSTraverse(table,isVisited,Brows,Bcloumns);
        if(result){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
    }

    public static boolean DFSTraverse(char[][]table,boolean[][]isVisited,int i,int j){
        if(table[i][j]=='H')
            return true;
        isVisited[i][j] = true;
        if(i-1>=0 && !isVisited[i-1][j] && table[i-1][j]!='#'){
            DFSTraverse(table,isVisited,i-1,j);
        }else if(i+1<table.length && !isVisited[i+1][j] && table[i+1][j]!='#'){
            DFSTraverse(table,isVisited,i+1,j);
        }else if(j-1>=0 && !isVisited[i][j-1] && table[i][j-1]!='#'){
            DFSTraverse(table,isVisited,i,j-1);
        }else if(j+1<table[0].length && !isVisited[i][j+1] && table[i][j+1]!='#'){
            DFSTraverse(table,isVisited,i,j+1);
        }
        return false;
    }


}
