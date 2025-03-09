package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15654_N과M5 {

    static int[] arr, res;
    static boolean[] vis;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        arr = new int[N];
        res = new int[M];
        vis = new boolean[10001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        comb(N, M, 0);
    }

    private static void comb(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[arr[i]]) {
                res[depth] = arr[i];
                vis[arr[i]] = true;
                comb(n, m, depth + 1);
                vis[arr[i]] = false;
            }
        }


    }
}
