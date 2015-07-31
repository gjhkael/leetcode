package dynamic;

/**
 * Created by hy on 2015/7/30.
 */
//动态规划求矩阵连乘问题
public class MatrixChain {

    public static void main(String[] args){
        int []test=new int[]{10,100,5,50};
        System.out.print(recurMaxtrixChain(1, 3, test));
        int[][]m=new int[3][3];
        int[][]s=new int[3][3];
        MatrixChainComputing(test,m,s);

    }


    public static int recurMaxtrixChain(int i,int j,int[] p){
        if(i==j) return 0;
        int min=recurMaxtrixChain(i,i,p)+recurMaxtrixChain(i+1,j,p)+p[i-1]*p[i]*p[j];
        for(int k=i+1;k<j;k++){
            int t=recurMaxtrixChain(i,k,p)+recurMaxtrixChain(k+1,j,p)+p[i-1]*p[k]*p[j];
            if(t<min)min=t;
        }
        return min;
    }

    public static int lookUpChain(int i,int j,int[][]m,int[] p){
        if(m[i][j]>0) return m[i][j];
        if(i==j) return 0;
        int min=recurMaxtrixChain(i,i,p)+recurMaxtrixChain(i+1,j,p)+p[i-1]*p[i]*p[j];
        for(int k=i+1;k<j;k++){
            int t=recurMaxtrixChain(i,k,p)+recurMaxtrixChain(k+1,j,p)+p[i-1]*p[k]*p[j];
            if(t<min)min=t;
        }
        m[i][j]=min;
        return min;
    }

    public static void MatrixChainComputing(int[]p,int [][]m,int[][]s){
        int n=p.length-1;
        for(int i=0;i<=n;i++) m[i][i]=0;
        for(int r=2;r<=n;r++){
            for(int i=1;i<=n-r+1;i++){
                int j=i+r-1;
                m[i][j]=m[i][i]+m[i+1][j]+p[i-1]*p[i]*p[j];
                for(int k=i;k<=j;k++){
                    int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }

    }



}
