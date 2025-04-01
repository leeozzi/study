package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2644_촌수계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        // 촌수를 계산해야 하는 두 사람
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());    // 부모 자식 간 관계의 수
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        visited[A] = true;
        int[] dist = new int[n + 1];

        while(!queue.isEmpty()) {
            int cur= queue.poll();

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                    visited[next] = true;
                    if(next == B) {
                        System.out.println(dist[B]);
                        return;
                    }
                }
            }
        }

        if(dist[B] == 0) System.out.println(-1);
    }   // main
}
