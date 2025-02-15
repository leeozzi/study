package BOJ;

import java.util.Scanner;

public class BOJ2444_별찍기7 {
    /**
     * 별 찍기 - 7
     * <a href="https://www.acmicpc.net/problem/2444">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(((n * 2 - 1) - (i * 2 - 1)) / 2));
            System.out.print("*".repeat(i * 2 - 1));
            System.out.println();
        }

        for (int i = n+1; i <= n*2-1; i++) {
            int blankCnt = i-n;
            System.out.print(" ".repeat(blankCnt));
            System.out.print("*".repeat((n*2-1)-2*blankCnt));
            System.out.println();
        }

    }
}
