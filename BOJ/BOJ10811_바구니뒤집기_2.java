package BOJ;

import java.util.Scanner;

public class BOJ10811_바구니뒤집기_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        int M = sc.nextInt();
        for (int l = 0; l < M; l++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            while(i<j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                i++;
                j--;
            }

        }

        for (int i = 1; i <= N; i++) {
            System.out.print(baskets[i] + " ");
        }

    }
}
