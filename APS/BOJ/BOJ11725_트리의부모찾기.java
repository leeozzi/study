package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] vis = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] p = new int[N + 1];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            vis[cur] = true;

            for (int next : graph.get(cur)) {
                if(!vis[next]){
                    vis[next] = true;
                    queue.offer(next);
                    p[next] = cur;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(p[i]);
        }
    }
}
