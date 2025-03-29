package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

/**
 * 특정한 최단 경로
 * https://www.acmicpc.net/problem/1504
 */

public class BOJ1504_특정한최단경로 {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist1, dist2, dist3;
    static int N, E, v1, v2;
    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "to: " + to + " (" + cost + ")";
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 노드 개수
        E = Integer.parseInt(input[1]); // 간선 개수
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선  추가
        for (int e = 0; e < E; e++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        input = br.readLine().split(" ");
        v1 = Integer.parseInt(input[0]);
        v2 = Integer.parseInt(input[1]);

        dist1 = new int[N + 1];
        dist2 = new int[N + 1];
        dist3 = new int[N + 1];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(dist3, INF);
        dist1[1] = 0;
        dist2[v1] = 0;
        dist3[v2] = 0;

        dijkstra(1, v1, dist1);
        dijkstra(v1, v2, dist2);
        dijkstra(v2, N, dist3);

        int v1First = INF;
        int v2First = INF;

        if(dist1[v1] != INF && dist2[v2] != INF && dist3[N] != INF)
            v1First = dist1[v1] + dist2[v2] + dist3[N];
        if(dist1[v2] != INF && dist3[v1] != INF && dist2[N] != INF)
            v2First = dist1[v2] + dist3[v1] + dist2[N];

        int ans = Math.min(v1First, v2First);

        if(ans != INF) System.out.println(ans);
        else System.out.println(-1);

    }

    private static void dijkstra(int start, int end, int[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            if (dist[curEdge.to] < curEdge.cost) continue;

            for (Edge e : graph.get(curEdge.to)) {
                if (dist[e.to] > dist[curEdge.to] + e.cost) {
                    dist[e.to] = dist[curEdge.to] + e.cost;
                    pq.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }
    }
}
