package Study.algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15651 {
    /**
     * N과 M (3)
     * <a href="https://www.acmicpc.net/problem/15651">...</a>
     */

    static int[] arr;
    static StringBuilder sb;
    static int[] com;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        com = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(n, m, 0);

        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(com[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            com[depth] = arr[i];
            dfs(n, m, depth + 1);
        }

    }

}
