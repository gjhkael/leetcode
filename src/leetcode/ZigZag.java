package leetcode;

/**
 * Created by havstack on 7/13/15.
 * 输入字符串PAYPALISHIRING 和一个数字（表示有多少行），按行输出字符串
 */


public class ZigZag {
    public String convert(String s, int numRows) {

        if(numRows==1){  //如果numRows为1，直接输出
            return s;
        }
        String result="";
        for(int i=0;i<s.length();i+=(2*numRows-2)){ //第一行和最后一行是特殊情况，只需要按间隔输出
            result+=s.charAt(i);
        }
        for(int i=1;i<numRows-1;i++){              //其他行需要特殊处理
            for(int j=i;j<s.length();j+=(2*numRows-2)){
                result+=s.charAt(j);
                if((j+2*numRows-2-2*i)<s.length())  //一个循环需要输出连个数字
                    result+=s.charAt(j+2*numRows-2-2*i);
            }
        }
        for(int i=numRows-1;i<s.length();i+=(2*numRows-2)){
            result+=s.charAt(i);
        }
        return result;
    }
}
