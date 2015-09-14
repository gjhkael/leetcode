package algorithm.leetcode;

/**
 * Created by hy on 2015/9/10.
 */
public class UniqueBinarySearchTrees {


    public int numTrees(int n) {
        if(n<=0)
            return 0;
        int []g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                g[i]+=g[j-1]*g[i-j];
            }
        }
        return g[n];
    }
}
