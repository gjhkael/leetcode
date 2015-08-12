package algorithm.leetcode;

import java.util.HashMap;

/**
 * Created by hy on 2015/7/27.
 */
//将罗马数字转成int，必须先搞清规则，如果当前字符是V，V左边的数字要是比V小，
// V需要减去这个数，比如IV是5-1 如果是右边：VI，应该是5+1=6

public class RomanToInteger {



    public int romanToInt(String s) { //罗马数字，首先需要明白各个字符的含义
        if(s==null||s.length()==0)
            return 0;
        int result=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        result=map.get(s.charAt(s.length()-1));
        int poviot=result;
        for(int i=s.length()-2;i>=0;i--){
            int cur=map.get(s.charAt(i));
            if(cur>=poviot)
                result+=cur;
            else
                result-=cur;
            poviot=cur;
        }
        return result;
    }
}
