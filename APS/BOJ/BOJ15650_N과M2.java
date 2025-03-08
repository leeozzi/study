package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15650_N과M2 {
    /**
     * N과 M (2)
     * <a href="https://acmicpc.net/problem/15650">...</a>
     */
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];
        res = new int[M];

        comb(M, 1, 0);
    }

    private static void comb(int m, int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                res[depth] = i;
                visited[i] = true;
                comb(m, i+1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
