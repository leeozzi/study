package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * N과 M (11)
 * <a href="https://acmicpc.net/problem/15665">...</a>
 */
public class BOJ15665_N과M11_2 {
    static int N, M;
    static int[] arr, res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        Set<Integer> set = new TreeSet<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        arr = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            arr[idx] = num;
            idx++;
        }

        res = new int[M];

        comb(0);
        System.out.println(sb);
    }

    private static void comb(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            res[depth] = arr[i];
            comb(depth + 1);
        }
    }
}
