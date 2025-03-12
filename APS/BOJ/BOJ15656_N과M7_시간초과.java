package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15656_N과M7_시간초과 {
    /**
     * N과 N (7)
     * <a href="https://www.acmicpc.net/problem/15656">...</a>
     */

    static int[] arr;
    static int[] res;
    static int N, M;

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
        System.out.println(Arrays.toString(arr));

        comb(0,0);
    }

    private static void comb(int start, int resIdx) {
        if(resIdx == M) {
            for(int i = 0 ;i < res.length ; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < N; i++) {
            res[resIdx] = arr[i];
            comb(start, resIdx+1);
        }
    }
}
