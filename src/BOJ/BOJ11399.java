package BOJ;

import java.lang.reflect.Array;
import java.util.*;

public class BOJ11399 {
    /**
     * ATM
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> mins = new ArrayList<>(n);
        for(int i =0 ; i < n ; i++) {
            mins.add(sc.nextInt());
        }

        Collections.sort(mins);


        int[] minsum = new int[n];
        for(int i=0 ; i < n ; i++) {
            int prefixsum = 0;
            for(int j = 0  ; j <= i ; j ++) {
                prefixsum+=mins.get(j);
            }
            minsum[i] = prefixsum;
        }

        int res = 0;
        for(int i= 0 ; i < minsum.length ; i++) {
            res += minsum[i];
        }

        System.out.println(res);
    }
}
