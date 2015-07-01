package leetcode;
/*
 * 最长字符串回文
 */
public class LongestPalindrome {
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		         
		String result = new LongestPalindrome().longestPalindrome(s);
		System.out.println(result);

	}

	public String longestPalindrome(String s) {  //垃圾算法，需要改进
		char[] c = new char[1000];
		int result = 0;
		int maxLength = -1;
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
		}
		for (int j = 0; j < 1000; j++) {
			for (int k = 0; k <= j; k++) {
				if ((j - k) >= 0 && (j + k) < 1000 && c[j + k] != '\0') {
					if (c[j - k] == c[j + k]) {
						result++;
					} else {
						break;
					}
				}
			}
			if (maxLength < result) {
				flag = false;
				maxLength = result;
				index = j;
			}
			result = 0;
			for (int k = 0; k <= j; k++) {

				if ((j - k) >= 0 && (j + k + 1) < 1000 && c[j + k + 1] != '\0') {
					if (c[j - k] == c[j + k + 1])
						result++;
					else
						break;
				}

			}
			if (maxLength < result) {
				maxLength = result;
				index = j;
				flag = true;
			}
			result = 0;
		}

		System.out.println(maxLength + " " + index + " " + flag);
		char[] temp = null;
		if (!flag) {
			temp = new char[2 * (maxLength - 1) + 1];
			for (int p = 0; p < 2 * (maxLength - 1) + 1; p++) {
				temp[p] = c[index - (maxLength - 1) + p];
			}
		} else {
			temp = new char[2 * maxLength];
			for (int p = 0; p < 2 * maxLength; p++) {
				temp[p] = c[index - maxLength + 1 + p];
			}

		}

		return new String(temp);

	}
}
