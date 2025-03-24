package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 죽음의 게임
 * https://www.acmicpc.net/problem/17204
 */
/*

 */
public class BOJ17204_죽음의게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        boolean[] vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int curr = 0;

        while (true) {
            if (curr == K) {
                System.out.println(count);
                return;
            }
            if (vis[curr]) { // 같은 곳 또 방문 -> 무한 루프
                System.out.println(-1);
                return;
            }
            vis[curr] = true;
            curr = arr[curr];
            count++;
        }
    }
}
