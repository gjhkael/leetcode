package algorithm.String;
/*
 * 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，这样的短句在智力性、
 * 趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 */
public class Palindrome {
	public static void main(String[] args){
		System.out.println(isPalindrome("woeoww"));
		
	}
	public static boolean isPalindrome(String s){
		boolean result=true;
		if(s==null||s.length()==0)
			return false;
		int length=s.length();
		int start=0,end=length-1;
		while(start<end){
			if(s.charAt(start)!=s.charAt(end)){
				result=false;
				break;
			}
			start++;
			end--;
		}
		return result;
	}
}
