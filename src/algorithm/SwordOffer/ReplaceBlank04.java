package algorithm.SwordOffer;

/**
 * Created by havstack on 8/21/15.
 */
public class ReplaceBlank04 {
    public static void main(String[] args){
        String test=" ";
        System.out.println(replaceBlank(test));
    }

    public static String replaceBlank(String s){
        if(s==null||s.length()==0)
            return s;
        int numBlank=0;
        for(int i=0,len=s.length();i<len;i++){
            if(s.charAt(i)==' ') numBlank++;
        }
        char []result =new char[s.length()+numBlank*2];
        int resultLength=result.length-1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ') {
                result[resultLength--]='0';
                result[resultLength--]='2';
                result[resultLength--]='%';
            }else{
                result[resultLength--]=s.charAt(i);
            }
        }
        String results=new String(result);
        return results;
    }

}
