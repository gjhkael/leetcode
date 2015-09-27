package structure;

import java.util.*;

/**
 * Created by hy on 2015/9/25.
 */
import java.awt.geom.Point2D;
import java.util.Scanner;

public class App {

    static void shuffle(int a[], int seed) {
        int n = a.length;
        Random rand = new Random(seed);
        for (; n > 1; n--) {
            int r = rand.nextInt(n);
            //System.out.println(r+"r ");
            int tmp = a[n - 1];
            a[n - 1] = a[r];
            a[r] = tmp;
        }

    }

    static void restore(int a[], int seed) {
        /* ÌîÐ´´úÂë */
        int n = a.length;
        Random rand = new Random(seed);
        int[] tmps=new int[n];
        for(;n>1;n--){
            int r =rand.nextInt(n);
            tmps[n-1]=r;
        }

        for (int i=0; i<a.length; i++) {
            int r = tmps[i];
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    public static void main(String[] args) {
        int seed, n, i;
        int[] a, b;
        Scanner input = new Scanner(System.in);
        {
            seed = input.nextInt();
            n = input.nextInt();
            a = new int[n];
            for (i = 0; i < n; ++i)
                a[i] = input.nextInt();
        }
        b = Arrays.copyOf(a, a.length);
        shuffle(a, seed);
        for( i=0;i<n;i++){
            System.out.println(a[i]);
        }

        restore(a, seed);
        for( i=0;i<n;i++){
            System.out.println(a[i]);
        }
        for (i = 0; i < n; i++) {
            if (a[i] != b[i])
                break;
        }
        if (i == n)
            System.out.printf("Success!\n");
        else
            System.out.printf("Failed!\n");
    }
}