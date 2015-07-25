package String;

/*
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 * 关键子：字母
 */
public class StringContain {
	// 时间负责度为o（n）空间复杂度为o(26)
	public static boolean stringContainSimple(char[] A, char[] B) {
		int[] contain = new int[26];
		for (int j = 0; j < 26; j++) {
			contain[j] = 0;
		}
		for (int i = 0; i < A.length; i++) {
			contain[A[i] - 'a'] = 1;
		}
		boolean result = true;
		for (int k = 0; k < B.length; k++) {
			if (contain[B[k] - 'a'] != 1) {
				result = false;
				break;
			}
		}
		Math.pow(2, 31);
		return result;
	}
	

	// 时间负责度为o（n）空间复杂度为o(1)
	public static boolean stringContainBest(char[] A, char[] B) {
		int hash=0;
		for(int i=0;i<A.length;i++){
			hash|=(1<<(A[i]-'a'));
		}
		for(int j=0;j<B.length;j++){
			System.out.println(hash&(1<<(B[j]-'a')));
			if((hash&(1<<(B[j]-'a')))==0)
				return false;
		}
		
		return true;
	}
	
	//如果两个字符串的字符一样，但是顺序不一样，被认为是兄弟字符串，比如bad和adb即为兄弟字符串，现提供一个字符串，如何在字典中迅速找到它的兄弟字符串，请描述数据结构和查询过程
	
	public static boolean iSBrotherWord(char[]A,char[]B){
		boolean result=true;
		int[] temp=new int[26];
		for (int j = 0; j < 26; j++) {
			temp[j] = 0;
		}
		for(int i=0;i<A.length;i++){
			temp[A[i]-'a']++;
		}
		for(int j=0;j<B.length;j++){
			temp[B[j]-'a']--;
		}
		for(int i=0;i<26;i++){
			if(temp[i]!=0){
				result=false;
				break;
			}
		}
		
		return result;
	}
	
	

	public static void main(String[] args) {
		boolean result = stringContainSimple("abcd".toCharArray(),
				"abbd".toCharArray());
		boolean result1 = stringContainBest("abcd".toCharArray(),"abd".toCharArray());
		System.out.println(iSBrotherWord("abcd".toCharArray(),"abdc".toCharArray()));
		System.out.println(result);
	}
}
