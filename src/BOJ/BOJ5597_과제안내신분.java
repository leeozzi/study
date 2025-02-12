package BOJ;

import java.util.Scanner;

public class BOJ5597_과제안내신분 {
    /**
     * 과제 안 내신 분..?
     * <a href="https://www.acmicpc.net/problem/5597">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stds = new int[31];

        for (int i = 0; i < 28; i++) {
            stds[sc.nextInt()] = 1;
        }

        for (int i = 1; i < 31; i++) {
            if (stds[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
