package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1753_최단경로 {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]); // 정점 개수
        int E = Integer.parseInt(input[1]); // 간선 개수
        int K = Integer.parseInt(br.readLine());    // 시작점

        // 그래프 만들기
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph.get(a).add(new Edge(b, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        pq.offer(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(dist[cur.to] < cur.cost) continue;

            for (Edge next : graph.get(cur.to)) {
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] != INF) System.out.println(dist[i]);
            else System.out.println("INF");
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

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
