package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15650_N과M2_2 {
    static int[] res;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
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

        for (int i = start; i <= N; i++) {
                res[depth] = i;
                comb(m, i+1, depth + 1);
        }
    }
}
