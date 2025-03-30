package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1922_네트워크연결 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();

        // 그래프 만들기
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        
        // 방문 배열 만들기
        boolean[] vis = new boolean[V + 1];

        // 비용 오름차순으로 간선 넣어줄 pq
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 임의의 한 정점(1번) 선택
        // 연결된 정점 다 넣어주기
        int pick = 1;
        vis[1] = true;
        pq.addAll(graph.get(1));

        int ans = 0;    // 최소비용 담아줄 것
        while(pick < V) {
            Edge e = pq.poll();
            if(vis[e.to]) continue; // 이미 이어준 애야

            ans += e.cost;
            vis[e.to] = true;
            pick++;
            pq.addAll(graph.get(e.to));
        }

        System.out.println(ans);

        
    }

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
