package algorithm.SwordOffer;

/**
 * Created by hy on 2015/9/28.
 */
public class PerMutation28 {

    public static void main(String[] args){
        char[] num = {'a','b','c'};
        permutation(num,0,2);
    }

    public static void permutation(char[] buf,int start,int end){
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                char temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;

                permutation(buf, start + 1, end);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

}
