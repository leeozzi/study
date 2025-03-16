package BOJ;

import java.util.Scanner;

/**
 * 모든 순열
 * <a href="https://www.acmicpc.net/problem/10974">...</a>
 */
public class BOJ10974_모든순열 {
    static int N;
    static int[] res;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        res = new int[N];
        vis = new boolean[N + 1];
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!vis[i]) {
                res[depth] = i;
                vis[i] = true;
                perm(depth + 1);
                vis[i] = false;
            }
        }
    }

}
