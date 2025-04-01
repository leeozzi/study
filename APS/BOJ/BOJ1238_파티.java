package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1238_파티 {

    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static List<List<Edge>> graph1, graph2;
    static int[] dist1, dist2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 노드 수
        M = Integer.parseInt(input[1]); // 간선 수
        X = Integer.parseInt(input[2]); // 목적지
        
        graph1 = new ArrayList<>();    // 오는 거
        graph2 = new ArrayList<>();    // 돌아가는 거
        for (int i = 0; i <= N; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph1.get(a).add(new Edge(b, c));
            graph2.get(b).add(new Edge(a, c));
        }

        dist1 = new int[N + 1];
        dist2 = new int[N + 1];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        dist1[X] = 0;
        dist2[X] = 0;

        dijkstra(graph1, dist1);
        dijkstra(graph2, dist2);

        int ans = 0;
        for(int i = 1 ; i <= N ; i++) {
            ans = Math.max(dist1[i] + dist2[i], ans);
        }

//        System.out.println(Arrays.toString(dist1));
//        System.out.println(Arrays.toString(dist2));
        System.out.println(ans);
    }

    public static void dijkstra(List<List<Edge>> graph, int[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.cost > dist[cur.to]) continue;

            for(Edge e : graph.get(cur.to)) {
                if(dist[e.to] > dist[cur.to] + e.cost) {
                    dist[e.to] = dist[cur.to] + e.cost;
                    pq.offer(e);
                }
            }
        }
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
