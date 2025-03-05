package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15655_N과M6 {
    /**
     * N과 M (6)
     * <a href="https://www.acmicpc.net/problem/15655">...</a>
     */

    static int n, m;
    static int[] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        arr = new int[input.length];
        res = new int[m];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        com(0, 0);
    }

    public static void com(int num, int depth) {

        if (depth == m) {
            for(int i = 0 ; i < m ; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }
        if (num == n) {
            return;
        }


        res[depth] = arr[num];
        com(num + 1, depth + 1);
        com(num + 1, depth);
    }
}
