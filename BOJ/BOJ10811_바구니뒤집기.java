package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10811_바구니뒤집기 {
    /**
     * 바구니 뒤집기
     * <a href="https://www.acmicpc.net/problem/10811">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int N = sc.nextInt();
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        int M = sc.nextInt();
        for (int l = 0; l < M; l++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int a = i <= j ? i : j;
            int b = i < j ? j : i;
            for (int x = a; x <= b; x++) {
                st.push(baskets[x]);
            }
            for (int x = a; x <= b; x++) {
                baskets[x] = st.pop();
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(baskets[i] + " ");
        }

    }
}
