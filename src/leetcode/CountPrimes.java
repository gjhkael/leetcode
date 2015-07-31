package leetcode;

/**
 * Created by hy on 2015/7/27.
 */
public class CountPrimes {
    public static void main(String[] args){
        System.out.println(countPrimes(7));
    }
    //统计素数的个数。
    public static int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] tmp=new boolean[n];
        int result=0;

        for(int i=2;i<n;i++)
            tmp[i]=true;
        for(int i=2;i<=n/2;i++){
            for(int j=i*2;j<n;j+=i){
                tmp[j]=false;
            }
        }
        for(int i=0;i<n;i++){
            if(tmp[i]==true)
                result++;
        }
        return result;
    }
}
