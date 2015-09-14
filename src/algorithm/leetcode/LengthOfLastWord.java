package algorithm.leetcode;

/**
 * Created by hy on 2015/9/14.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s==null){
            return 0;
        }
        int result=0;
        int lastIndex=s.length()-1;
        for(int i=lastIndex;i>=0;i--){
            if(s.charAt(i)==' '){
                lastIndex--;
            }else{
                break;
            }
        }
        for(int i=lastIndex;i>=0;i--){
            if(s.charAt(i)==' '){
                break;
            }else {
                result++;
            }
        }

        return result;
    }
}
