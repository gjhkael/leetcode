package String;
//最长回文字串
public class LongestPalindrome {

	public static void main(String[] args) {
		String s = longestPalindrome1("woooow");
		int[] p = new int[12];
		System.out.println(p[1]);
		System.out.println(s);
		//System.out.println(change("fwf"));
		System.out.println(longestPalindrome2(change("")));
	}                                                 

	public static String longestPalindrome1(String s) {
		int max = 0;
		int temp = 0;
		int index = 0;
		if (s == null || s.length() == 0)
			return null;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; (i - j >= 0) && (i + j) < s.length(); j++) {
				if (s.charAt(i - j) != s.charAt(i + j))
					break;
				temp = 2 * j + 1;
			}
			if (temp > max) {
				max = temp;
				index = i;
			}

			for (int j = 0; (i - j) >= 0 && (i + j + 1) < s.length(); j++) {
				if (s.charAt(i - j) != s.charAt(i + j + 1)) {
					break;
				}
				temp = 2 * j + 2;
			}
			if (temp > max) {
				max = temp;
				index = i;
			}
		}

		System.out.println(max + "" + index);

		if (max % 2 == 0) {
			return s.substring(index - max / 2 + 1, index + max / 2 + 1);
		} else {
			return s.substring(index - max / 2, index + max / 2 + 1);
		}
	}

	public static String longestPalindrome2(String s) {
		int[] p = new int[10000];
		int mx = 0, id = 0,ans=1;
		int index=0;
		for (int i = 1; s.charAt(i) != '\0'; i++) {
			
			p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
			while (s.charAt(i + p[i]) == s.charAt(i - p[i]))
				p[i]++;
			if (i + p[i] > mx) {
				mx = i + p[i];
				id = i;
			}
			if(ans<p[i]){
				ans=p[i];
				index=i;
			}
		}
		StringBuffer result=new StringBuffer();
		
		for(int i=index-ans+1;i<index+ans-1;i++){
			if(s.charAt(i)!='#'&&s.charAt(i)!='@'){
				result.append(s.charAt(i));
			}
		}
		
		System.out.println(ans-1+" "+id+" "+mx+" "+ans);
		return result.toString();
	}
	
	public static String change(String s){
		StringBuffer newStr=new StringBuffer();
		newStr.append('@');
		newStr.append('#');
		for(int i=0;i<s.length();i++){
			newStr.append(s.charAt(i));
			newStr.append('#');
		}
		newStr.append('\0');
		System.out.println(newStr);
		return newStr.toString();
	}

}
