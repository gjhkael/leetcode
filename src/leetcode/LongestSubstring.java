package leetcode;
/*
 * 最长字串（这个字符串中没有重复的字符）
 */
import java.util.LinkedList;
import java.util.List;
public class LongestSubstring {
	
	   public int lengthOfLongestSubstring(String s) {
	        int result=0;
	        int maxLength=0;
	        List<Character> temp=new LinkedList<Character>();
	        for(int i=0;i<s.length();i++){
	        	char c=s.charAt(i);
	            if(!temp.contains(c)){
	                temp.add(c);
	                maxLength++;
	                if(maxLength>result)
	                	result=maxLength;
	            }else{
	                int j=temp.indexOf(c);
	                for(int k=j;k>=0;k--){
	                    temp.remove(k);
	                }
	                temp.add(c);
	                maxLength=maxLength-j;
	                if(maxLength>result)
	                    result=maxLength;
	            }
	        }
	        return result;
	    }
	
	public static void main(String[] args){
		int result=new LongestSubstring().lengthOfLongestSubstring("qjgjtsfltqpbkpx");
		
		System.out.println(result);
	}
}
