package algorithm.SwordOffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hy on 2015/9/6.
 */
public class Combination {
    public static void main(String[] args){

        LinkedList<String>result = permutation("abc");
        for(String s:result){
            System.out.println(s);
        }
    }

    //字符串的全组合
    public static void combiantion(char chs[]){
        if(chs.length == 0) return ;

        Stack<Character> stack = new Stack<Character>();
        for(int i = 1; i <= chs.length; i++){
            combine(chs, 0, i, stack);
        }
    }
    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char []chs, int begin, int number, Stack<Character> stack){
        if(number == 0){
            System.out.println(stack.toString());
            return ;
        }
        if(begin == chs.length){
            return;
        }
        stack.push(chs[begin]);
        combine(chs, begin + 1, number - 1, stack);
        stack.pop();
        combine(chs, begin + 1, number, stack);
    }


    //字符串的全排列
    public static LinkedList<String> permutation(String str) {

        LinkedList<String> linkedString = new LinkedList<String>();
        if (str.length() <= 1) {
            linkedString.add(str);
            return linkedString;
        }
        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            //consider the case in which the characters may be duplicated.
            if (i > 0 && ch == str.charAt(i - 1)) {
                continue;
            }
            String newStr = remove(str, i);
            LinkedList<String> newStrList= permutation(newStr);
            for (int j = 0; j < newStrList.size(); j++) {
                linkedString.add(ch + newStrList.get(j));
            }
        }
        return linkedString;
    }
    //remove the ith character from the string
    public static String remove(String str, int i) {
        if (i == 0) return str.substring(1, str.length());
        if (i == str.length() - 1) return str.substring(0, i );
        return str.substring(0, i) + str.substring(i + 1, str.length());
    }
}
