package SWEA;

import java.util.Scanner;

public class SWEA1970_쉬운거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] cnt = new int[8];

            for (int i = 0; i < 8; i++) {
                cnt[i] = n / money[i];
                n %= money[i];
            }

            System.out.println("#" + t);
            for(int i = 0 ;i < 8 ; i++) {
                System.out.print(cnt[i] + " ");
            }
            System.out.println();
        }
    }
}
