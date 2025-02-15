package groupstudy.algorithm_study;

import java.util.*;

public class BOJ15649_N과M1 {
    /**
     * N과 M (1)
     * <a href="https://www.acmicpc.net/problem/15649">...</a>
     */

    static int[] arr;
    static int[] visited;
    static int[] combi;

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        visited = new int[n];
        combi = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(n, m, 0);

        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth) {

        if (depth == m) {
            for (int e : combi) {
                sb.append(e + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                combi[depth] = arr[i];
                visited[i] = 1;
                dfs(n, m, depth + 1);
                visited[i] = 0;
            }

        }

    }


}
