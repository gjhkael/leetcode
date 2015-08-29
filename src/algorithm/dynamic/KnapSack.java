package algorithm.dynamic;

/**
 * Created by hy on 2015/8/3.
 */
//0 1 背包问题
public class KnapSack {

    public static void main(String[] args){
        int weigth[]=new int[]{3,2,2,1};
        int vaule[]=new int[]{100,10,20,50};
        int volume=5;
        System.out.println(knapSack(weigth,vaule,volume));
    }

    public static int knapSack(int[]weight,int[]value,int volume){
        if(weight.length==0||value.length==0||volume<=0){
            return 0;
        }
        int wLength=weight.length;
        int[][]tmp=new int[wLength+1][volume+1]; //记录物品i放到volume中的价值
        for(int i=1;i<=wLength;i++){
            for(int j=0;j<=volume;j++){
                tmp[i][j]=tmp[i-1][j];  //如果j<weight[i-1],直接跳过，赋值为i-1的值
                if(j>=weight[i-1]){
                    tmp[i][j]=max(tmp[i-1][j],tmp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return tmp[wLength][volume];
    }

    public static int max(int a,int b){
        return a>b?a:b;
    }
}
