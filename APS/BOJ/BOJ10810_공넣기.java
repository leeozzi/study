package BOJ;

import java.util.Scanner;

public class BOJ10810_공넣기 {
    /**
     * 공 넣기
     * <a href="https://www.acmicpc.net/problem/10810">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] basket = new int[N];
        int M = sc.nextInt();
        for (int l = 0; l < M; l++) {
            int i = sc.nextInt();   // i번 바구니부터
            int j = sc.nextInt();   // j번 바구니까지
            int k = sc.nextInt();   // 공의 숫자

            for(int x = i ; x <= j ; x++) {
                basket[x-1] = k;
            }
        }

        for(int i = 0 ; i < N ; i++) {
            System.out.print(basket[i] + " ");
        }

    }
}
