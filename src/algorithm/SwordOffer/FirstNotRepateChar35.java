package algorithm.SwordOffer;

import java.util.HashMap;

/**
 * Created by havstack on 9/7/15.
 */
public class FirstNotRepateChar35 {

    public static void main(String[] args){
        System.out.println(firstNotRepateChar("abaccdef".toCharArray()));
    }

    public static Character firstNotRepateChar(char[] chars){
        if(chars==null || chars.length==0){
            return null;
        }
        char result=' ';
        HashMap<Character,Integer> tmp=new HashMap<Character,Integer>();
        for(int i=0;i<chars.length;i++){
            char s=chars[i];
            if(tmp.containsKey(s)){
                int t=tmp.get(s)+1;
                tmp.put(s,t);
            }else{
                tmp.put(s,1);
            }
        }
        for(int i=0;i<chars.length;i++){
            if(tmp.get(chars[i])==1){
                result=chars[i];
                break;
            }
        }
        return result;
    }
}
