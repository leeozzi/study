package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15656_N과M7 {
    /**
     * N과 N (7)
     * <a href="https://www.acmicpc.net/problem/15656">...</a>
     */

    static int[] arr;
    static int[] res;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        arr = new int[N];
        res = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        perm(0);

        System.out.println(sb);
    }

    public static void perm(int depth) {
        if (depth == M) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < arr.length ; i++) {
            res[depth] = arr[i];
            perm(depth+1);
        }
    }

}
