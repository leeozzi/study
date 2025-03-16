package BOJ;

import java.io.*;
import java.util.*;

/**
 * N과 M (9)
 * <a href="https://acmicpc.net/problem/15663">...</a>
 */

public class BOJ15663_N과M9 {
    static int[] arr, res;
    static boolean[] vis;
    static Set<String> set = new HashSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];
        res = new int[M];
        vis = new boolean[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        comb(0);

    }

    public static void comb(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }

            if (!set.contains(String.valueOf(sb))) {
                set.add(String.valueOf(sb));
                System.out.println(sb);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                res[depth] = arr[i];
                vis[i] = true;

                comb(depth + 1);
                vis[i] = false;
            }
        }
    }
}
