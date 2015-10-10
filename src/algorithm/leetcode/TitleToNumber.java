package algorithm.leetcode;

/**
 * Created by hy on 2015/7/29.
 */
public class TitleToNumber {
    public static void main(String[] args){
        System.out.println(titleToNumber("ABC"));

    }

    public static int titleToNumber(String s) {
        if(s==null || s.length()<=0)
            return 0;
        int length=s.length();
        int index=0;int result=0;
        //去掉前缀空格
        while(s.charAt(index)==' '){
            index++;
        }
        //开始计算
        for(int i=index;i<length;i++){
            int tmp=s.charAt(i)-'A'+1;
            if(tmp>26||tmp<0)  //不符合条件的字符则直接跳出
                break;                                 //越界还需要检测
            if(Integer.MAX_VALUE/26<result||((Integer.MAX_VALUE/26==result)&&(Integer.MAX_VALUE%26<tmp)))
                return Integer.MAX_VALUE;
            result=result*26+(tmp);
        }
        return result;


    }
}
