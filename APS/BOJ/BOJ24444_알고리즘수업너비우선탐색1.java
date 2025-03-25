package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 알고리즘 수업 - 너비 우선 탐색 1
 * <a href="https://www.acmicpc.net/problem/24444">...</a>
 */

public class BOJ24444_알고리즘수업너비우선탐색1 {

    static int N, M, R;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] vis;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        vis = new boolean[N + 1];
        res = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            arr.get(A).add(B);
            arr.get(B).add(A);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        bfs(R);

        for(int i = 1 ; i <= N ; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 1;
        queue.offer(cur);
        vis[cur] = true;
        res[cur] = cnt;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int i = 0; i < arr.get(cur).size(); i++) {
                int x = arr.get(cur).get(i);

                if (!vis[x]) {
                    queue.offer(x);
                    vis[x] = true;
                    res[x] = ++cnt;
                }
            }
        }
    }   // bfs
}
