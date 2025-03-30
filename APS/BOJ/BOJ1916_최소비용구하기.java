package BOJ;

import java.io.*;
import java.util.*;

/**
 * 최소비용 구하기
 * <a href="https://acmicpc.net/problem/1916">...</a>
 */
public class BOJ1916_최소비용구하기 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        // graph 만들기
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for(int i = 0 ; i < E ; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph.get(a).add(new Edge(b, c));
        }

        // 출발지 도착지 입력 받기
        input = br.readLine().split(" ");
        int from = Integer.parseInt(input[0]);
        int to = Integer.parseInt(input[1]);

        ///  입력 끝

        // 다익스트라 기본 세팅
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[from] = 0;
        pq.offer(new Edge(from, 0));

        // 다익스트라
        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(cur.cost > dist[cur.to]) continue;

            for(Edge e : graph.get(cur.to)) {
                if(dist[e.to] > dist[cur.to] + e.cost) {
                    dist[e.to] = dist[cur.to] + e.cost;
                    pq.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }

        System.out.println(dist[to]);
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
