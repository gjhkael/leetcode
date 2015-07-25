package String;

public class StrToInt {
	private static final int MAX_INT = (int) Math.pow(2, 31) - 1;
	private static final int MIN_INT = (int) Math.pow(2, 31);

	public static int strToint(char[] str) {
		int sign = 1;
		int result = 0;
		if (str[0] == '-') {
			sign = -1;
		}
		if (str[0] == '-' || str[0] == '+') {
			for (int i = 1; i < str.length; i++) {
				int temp=str[i]-'0';
				if (temp < 10) {
					if(sign>0&&(result>MAX_INT/10 || (result==MAX_INT/10 && temp>MAX_INT%10))){
						result=MAX_INT;
						break;
					}else if(sign<0&&(result<MIN_INT/10 ||(result==MIN_INT/10 && temp<MAX_INT%10))){
						result=MIN_INT;
						break;
					}else{
						
						result=result*10+temp;
					}
				} else {
					return 0;
				}

			}

		} else {
			for (int i = 0; i < str.length; i++) {
				int temp=str[i]-'0';
				if (temp < 10) {
					if(sign>0&&(result>MAX_INT/10 || (result==MAX_INT/10 && temp>MAX_INT%10))){
						result=MAX_INT;
						break;
					}else if(sign<0&&(result<MIN_INT/10 ||(result==MIN_INT/10 && temp<MAX_INT%10))){
						result=MIN_INT;
						break;
					}else{
						result=result*10+temp;
					}
					
					
				} else {
					return 0;
				}
			}
		}
		
		return sign>0?result:-result;
	}

	public static void main(String[] args) {
		int result=strToint("-123987489374973".toCharArray());
		int s=Integer.parseInt("12394973");
		System.out.println(s);
		System.out.println(result);
		System.out.println(Double.MAX_VALUE);
		float test=0.32344435f;
		double test1=1221323.232323233232332322;
		System.out.println(test);
		System.out.println(test1);
		Long t=34L;
	}
}
