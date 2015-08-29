package algorithm.leetcode;

import java.util.HashMap;

/**Given two strings s and t, determine if they are isomorphic.
 * Created by gjh on 2015/7/27.
 *Given "egg", "add", return true.
 *Given "foo", "bar", return false.
 *Given "paper", "title", return true.
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int []tmp1=new int[s.length()];
        int []tmp2=new int[s.length()];
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                tmp1[i]=map.get(s.charAt(i));
            }else{
                tmp1[i]=-1;
                map.put(s.charAt(i),i);
            }
        }
        map=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                tmp2[i]=map.get(t.charAt(i));
            }else{
                tmp2[i]=-1;
                map.put(t.charAt(i),i);
            }

        }
        for(int i=0;i<s.length();i++){
            if(tmp1[i]!=tmp2[i])
                return false;
        }
        return true;

    }
}
