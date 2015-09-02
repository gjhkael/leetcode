package algorithm.SwordOffer;

/**
 * Created by havstack on 8/27/15.
 */
public class Pow {

    public static void main(String[] args){
        System.out.println(Pow(2,4));
        System.out.println(Pow1(2,4));
    }

    public static double Pow(double base,int exponent){  //不够高效的算法
        if(-0.0000001<base&&base<0.0000001){
            return 0.0;
        }
        if(exponent==0){
            return 1.0;
        }
        boolean flag=false;
        double result=1;
        if(exponent<0){
            exponent=(-1)*exponent;
            flag=true;
        }
        for(int i=0;i<exponent;i++){
            result*=base;
        }
        if(flag){
            return 1/result;
        }else{
            return result;
        }
    }

    public static double Pow1(double base,int exponent){  //不够高效的算法
        if(-0.0000001<base&&base<0.0000001){
            return 0.0;
        }
        if(exponent==0) {
            return 1.0;
        }
        if(exponent==1){
            return base;
        }

        boolean flag=false;
        double result=1;
        if(exponent<0){
            exponent=(-1)*exponent;
            flag=true;
        }
        result=Pow1(base,exponent>>1);
        result*=result;
        if((exponent&1)==1){
            result*=base;
        }
        if(flag){
            return 1/result;
        }else{
            return result;
        }
    }
}
