package algorithm.SwordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by havstack on 9/7/15.
 */
public class PrintMinNumber {

    public static void main(String[] args){
        int[] test={121,3,32};
        printMinNumber(test);
    }
    public static void printMinNumber(int[] numbers){
        if(numbers == null || numbers.length == 0)
            return;
        int length = numbers.length;
        List<MyString> result = new ArrayList<MyString>();
        for(int i=0;i<length;i++){
            result.add(new MyString(numbers[i]+""));
        }
        Collections.sort(result);
        for(MyString s:result){
            System.out.print(s);
        }
        System.out.println(" ");
    }
}

class MyString implements Comparable<MyString> {
    private String s;
    public MyString(String s){
        this.s=s;
    }
    @Override
    public String toString(){
        return s;
    }
    @Override
    public int compareTo(MyString o) {
        String s1=s+o;
        String s2=o+s;
        if(s1.compareTo(s2)>0){
            return 1;
        }else if(s1.compareTo(s2)<0){
            return -1;
        }else{
            return 0;
        }
    }
}