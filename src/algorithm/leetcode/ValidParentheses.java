package algorithm.leetcode;

import java.io.InvalidClassException;
import java.util.Stack;

/**
 * Created by hy on 2015/8/11.
 */
public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(isValid("(){}[]"));
    }

    public static boolean isValid(String s) {
        if(s==null||s.length()==0)
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char tmp=s.charAt(i);
            if(tmp=='('||tmp=='{'||tmp=='[')
                stack.push(tmp);
            else if(tmp==')'||tmp=='}'||tmp==']'){
                if(stack.isEmpty())
                    return false;
                char pre=stack.pop();
                if(tmp-pre==1||tmp-pre==2){
                    continue;
                }else{
                    System.out.println(tmp-pre);
                    return false;
                }
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;

    }
}
