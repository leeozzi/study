package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9742_순열 {
    /**
     * 순열
     * <a href="https://www.acmicpc.net/problem/9742">...</a>
     */

    static char[] arr, res;
    static int N;
    static int num; // 몇 번째 순선지 담아줌
    static boolean[] vis;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str != null) {
            sb = new StringBuilder();
            String[] input = str.split(" ");
            arr = input[0].toCharArray();
            res = new char[arr.length];
            vis = new boolean[arr.length];
            N = Integer.parseInt(input[1]);
            num = 0;

            sb.append(input[0]).append(" ").append(N).append(" = ");
            perm(0);

            if(num < N) {
                sb.append("No permutation");
            }
            System.out.println(sb);
            str = br.readLine();
        }
    }

    public static void perm(int residx) {
        if (residx == res.length) {
            num++;
            if(num == N) {
                for (int i = 0; i < res.length; i++) {
                    sb.append(res[i]);
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                res[residx] = arr[i];
                vis[i] = true;
                perm(residx + 1);
                vis[i] = false;
            }
        }
    }
}
