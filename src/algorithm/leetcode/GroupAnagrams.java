package algorithm.leetcode;

import java.util.*;

/**
 * Created by havstack on 8/18/15.
 */
public class GroupAnagrams {

    public static void main(String[] args){
        String[] str={"and","dan"};
        System.out.println(new GroupAnagrams().groupAnagrams(str));
    }

    public List<List<String>> groupAnagram(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String,Integer> mp = new HashMap<String,Integer>();
        Arrays.sort(strs);
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(mp.containsKey(s)){
                List li = res.get(mp.get(s));
                li.add(str);
            }else{
                List li = new ArrayList();
                li.add(str);
                res.add(li);
                mp.put(s,res.size()-1);
            }
        }
        return res;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<List<String>>();
        if(strs==null||strs.length==0){
            return result;
        }
        HashMap<String,Integer> tmp=new HashMap<String,Integer>();
        int index=0;
        Arrays.sort(strs);
        for(int i=0,len=strs.length;i<len;i++){
            String s=sort(strs[i]);
            if(tmp.containsKey(s)){
                int indexInList=tmp.get(s);
                result.get(indexInList).add(strs[i]);
            }else{
                List<String> strings=new ArrayList<String>();
                strings.add(strs[i]);
                result.add(strings);

                tmp.put(s, index);

                index++;
            }
        }
        return result;
    }

    public String sort(String s){
        char[] tmp=s.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}
