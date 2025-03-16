package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * N과 M (11)
 * <a href="https://acmicpc.net/problem/15665">...</a>
 */
public class BOJ15665_N과M11 {
    static int N, M;
    static int[] arr, res;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];
        res = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        comb(0);
    }

    private static void comb(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }

            if (!set.contains(String.valueOf(sb))) {
                set.add(String.valueOf(sb));
                System.out.println(sb);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            res[depth] = arr[i];
            comb(depth + 1);
        }
    }
}
