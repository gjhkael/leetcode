package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by hy on 2015/8/12.
 */
public class SimplifyPath {


    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<String>();
        Set<String> set=new HashSet<String>(Arrays.asList("..", ".", ""));
        for(String s:path.split("/")){
            if(s.equals("..")&&(!stack.isEmpty()))stack.pop();
            else if(!set.contains(s)){
                stack.push(s);
            }
        }
        String res="";
        while(!stack.isEmpty()){
            res="/"+stack.pop()+res;
        }
        return res.isEmpty()?"/":res;
    }
}
