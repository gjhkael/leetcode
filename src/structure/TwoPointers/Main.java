package structure.TwoPointers;

import java.util.Scanner;

/**
 * Created by kael on 2015/9/28.
 */
public class Main {
     public static int is_include(char a[], char b[])
    {
        int find = 0;
        for(int i = 0; i < b.length; ++i)
        {
            for(int j = 0; j < a.length; ++j)
            {
                if (String.valueOf(b[i]).equalsIgnoreCase(String.valueOf(a[j]))) {
                    find = 1;
                    break;
                }
            }
        }
        return find;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        char a[] = str1.toCharArray();
        char b[] = str2.toCharArray();
        int result = is_include(a, b);
        System.out.print(result);
    }
}
