package BOJ;

import java.io.*;
import java.util.*;

/**
 * 숨바꼭질 3
 * <a href="https://acmicpc.net/problem/13549">...</a>
 */

public class BOJ13549_숨바꼭질3 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 시작 위치
        int K = Integer.parseInt(input[1]); // 도착 위치

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= 100000; i++) {
            if (i + 1 <= 100000)
                graph.get(i).add(new Edge(i + 1, 1));
            if (i > 0)
                graph.get(i).add(new Edge(i - 1, 1));
            if (i * 2 <= 100000)
                graph.get(i).add(new Edge(i * 2, 0));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, INF);
        dist[N] = 0;
        pq.offer(new Edge(N, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Edge e : graph.get(cur.to)) {
                if (dist[e.to] > dist[cur.to] + e.cost) {
                    dist[e.to] = dist[cur.to] + e.cost;
                    pq.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }

        System.out.println(dist[K]);
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
