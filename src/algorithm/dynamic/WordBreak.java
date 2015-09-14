package algorithm.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hy on 2015/9/1.
 */
public class WordBreak {
    public static void main(String[]args){
        Set<String> s=new HashSet<String>();
        System.out.println(new WordBreak().wordBreak("leetcode",s));
    }
    public static boolean wordBreak(String s,Set<String> dict){
        boolean []f=new boolean[s.length()+1];
        Arrays.fill(f,false);
        f[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){   //如果在j处刚好是存在单词在单词集中，并且j-i位置的切割也在单词集中，那么f[i]为true
                if(f[j]&&dict.contains(s.substring(j,i))){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
