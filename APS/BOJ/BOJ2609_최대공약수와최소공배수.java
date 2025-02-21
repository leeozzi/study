package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2609_최대공약수와최소공배수 {
    /**
     * 최대공약수와 최소 공배수
     * <a href="https://www.acmicpc.net/problem/2609">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        List<Integer> divisor1 = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) divisor1.add(i);
        }

        List<Integer> divisor2 = new ArrayList<>();
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) divisor2.add(i);
        }

        List<Integer> standard;
        List<Integer> theother;
        if (a > b) {
            standard = divisor2;
            theother = divisor1;
        } else {
            standard = divisor1;
            theother = divisor2;
        }

        int maxdiv = 0;

        for (Integer i : standard) {
            if (theother.contains(i)) {
                maxdiv = Math.max(maxdiv, i);
            }
        }

        System.out.println(maxdiv);
        System.out.println(a*b/maxdiv);
    }
}
