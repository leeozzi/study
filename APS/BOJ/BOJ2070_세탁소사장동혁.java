package BOJ;

import java.util.Scanner;

public class BOJ2070_세탁소사장동혁 {
    /**
     * 세탁소 사장 동혁
     * <a href="https://www.acmicpc.net/problem/2720">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int C = sc.nextInt();

            int q = C/25;
            int d = (C-q*25)/10;
            int n = (C-q*25-d*10)/5;
            int p = C-q*25-d*10-n*5;

            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}
