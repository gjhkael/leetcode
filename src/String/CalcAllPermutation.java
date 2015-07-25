package String;

import java.util.List;

/*
 * 输入一个字符串，打印出该字符串中字符的所有排列。

 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串

 abc、acb、bac、bca、cab 和 cba。
 */
public class CalcAllPermutation {
	public static void calcAllpermutation(char[] s, int start, int end) {
		if (end == 0)
			return;
		if (start == end) {
			for (int i = 0; i < s.length; i++)
				System.out.print(s[i]);
			System.out.println("");
		} else {
			for (int j = start; j <= end; j++) { //每个字符通过与后面的字符交换来达到将所有的字符组合
					if(isSwap(s,start,j)){       //判斷後面是否有重複的字符，如果有的話，就不合它交換了，
						swap(s, start, j);
						calcAllpermutation(s, start + 1, end);
						swap(s, start, j);
					}
			}
		}
	}
	
	//上述算法如果传入的字符有相同的字符的话，会出现结果重复，需要添加判断条件，条件就是如果当前字符只和后面的非重复字符进行交换，
	public static void swap(char[] s, int i, int j) { //交换两个字符
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	public static boolean isSwap(char[] s,int i,int j){
		for(;i<j;i++){
			if(s[i]==s[j])
				return false;
		}
		return true;
	}
	static int num=1;
	
	//题目：输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
	public static void combination(char[]s,int number,List<Character>result){
		if(s==null){
			return;
		}
		if(s.length==0){
			System.out.println("第"+num+"个组合");
			for(Character c:result){
				System.out.print(c);
			}
			System.out.println();
		}
		
		
		
	}
	

	public static void main(String[] args) {
		calcAllpermutation("abb".toCharArray(), 0, 2);
	}
}
