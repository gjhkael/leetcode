package algorithm.leetcode;

/**
 * Created by havstack on 8/21/15.
 */
public class AddBinary {

    public static void main(String[] args){

        System.out.println( new AddBinary().addBinary("1","1"));
    }

    public String addBinary(String a, String b) {
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        int processUp=0;
        StringBuilder result=new StringBuilder("");
        char[]aChar=a.toCharArray();
        char[]bChar=b.toCharArray();
        int aLength=aChar.length-1;
        int bLength=bChar.length-1;
        int aByte=0;
        int bByte=0;
        while(aLength>-1||bLength>-1||processUp==1){
            aByte = (aLength > -1) ? Character.getNumericValue(aChar[aLength--]) : 0;
            bByte = (bLength > -1) ? Character.getNumericValue(bChar[bLength--]) : 0;
            int res=aByte^bByte^processUp;
            processUp=(aByte+bByte+processUp)>=2?1:0;
            result.append(res+"");
        }
        return result.reverse().toString();
    }

}
