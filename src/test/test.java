package test;

/**
 * Created by havstack on 7/18/15.
 */
public class test {
    public static void main(String[] args){

        System.out.println(myAtoi("2147483648"));


    }
    public static int myAtoi(String str) {
        int result=0;
        if(str.equals("")){
            return 0;
        }else{
            int j=0;
            while(str.charAt(j)==' '){
                j++;
            }
            if(str.charAt(j)=='+'||str.charAt(j)=='-'){
                if(str.charAt(j+1)=='+'||str.charAt(j+1)=='-')
                    return 0;
                for(int i=j+1;i<str.length();i++){
                    if((48<=str.charAt(i)&&str.charAt(i)<=57) && (result*10+(str.charAt(i)-48)<=Integer.MAX_VALUE) ){
                        result=10*result+(str.charAt(i)-48);
                    }else{
                        if(str.charAt(j)=='-')
                            result=result*(-1);
                        else
                            result=Integer.MAX_VALUE;
                            return result;


                    }
                }
                if(str.charAt(j)=='-'){
                    result=result*(-1);
                }
            }else{

                for(int i=j;i<str.length();i++){
                    if((48<=str.charAt(i)&&str.charAt(i)<=57) && (result*10+(str.charAt(i)-48)<=Integer.MAX_VALUE) ){
                        result=10*result+(str.charAt(i)-48);
                    }else{
                        if(result*10+(str.charAt(i)-48)>Integer.MAX_VALUE)
                        result=Integer.MAX_VALUE;
                        return result;

                    }
                }

            }
        }
        return result;
    }


}
