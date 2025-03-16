package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N과 M (8)
 * <a href="https://www.acmicpc.net/problem/15657">...</a>
 */

public class BOJ15657_N과M8 {

    static int[] arr;
    static int[] res;
    static int N, M;

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

        comb(0, 0);
    }

    public static void comb(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < N ; i++) {
            res[depth] = arr[i];
            comb(i, depth+1);
        }
    }
}
