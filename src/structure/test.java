package structure;

/**
 * Created by kael on 2015/10/1.
 */
public class test {

    public static void main(String[] args){
        test(12345678);
    }

    public static void test(int n){
        if(n<10) {
            System.out.print(n);
            return;
        }
        System.out.print(n%10);
        test(n/10);
    }
}
