package algorithm.SwordOffer;

/**
 * Created by havstack on 8/27/15.
 */
public class Print1ToMaxOfN {
    public static void main(String[] args){

        print1ToMaxofN(4);
    }

    public static void print1ToMaxofN(int n){
        if(n<=0)
            return ;
        char[] number=new char[n];
        for(int i=0;i<n;i++){
            number[i]='0';
        }
        while(!increment(number)){
            printNumber(number);
        }
    }

    public static boolean increment(char[] number){
        boolean isOverflow=false;
        int length=number.length;
        int nTakeOver=0;
        for(int i=length-1;i>=0;i--){
            int nSum=number[i]-'0'+nTakeOver;
            if(i==length-1){
                nSum++;
            }
            if(nSum>=10){
                if(i==0)
                    isOverflow=true;
                else{
                    nSum-=10;
                    nTakeOver=1;
                    number[i]=(char)('0'+nSum);
                }
            }else{
                number[i]=(char)('0'+nSum);
                break;
            }
        }
        return  isOverflow;
    }
    public static void printNumber(char[] number){
        boolean isBegining0=true;
        int length=number.length;
        for(int i=0;i<length;i++){
            if(isBegining0&&number[i]!='0'){
                isBegining0=false;
            }
            if(!isBegining0){
                System.out.print(number[i]);
            }
        }
        System.out.println("");
    }
}
