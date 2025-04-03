package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352_특정거리의도시찾기_다익스트라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<List<Edge>> graph = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(input[0]); // 노드 개수
        int M = Integer.parseInt(input[1]); // 간선 개수
        int K = Integer.parseInt(input[2]); // 거리 정보
        int X = Integer.parseInt(input[3]); // 출발 도시 번호

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(new Edge(b, 1));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Edge(X, 0));
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.cost) continue;

            for (Edge e : graph.get(cur.to)) {
                if (dist[e.to] > dist[cur.to] + e.cost) {
                    dist[e.to] = dist[cur.to] + e.cost;
                    pq.offer(new Edge(e.to, dist[e.to]));
                }
            }
        }


        // 출력

        boolean flag = false;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == K) {
                flag = true;
                sb.append(i).append("\n");
            }
        }
        if(!flag) {
            sb.append(-1);
        }
        System.out.println(sb);
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

        @Override
        public String toString() {
            return to +
                    "(" + cost +
                    ')';
        }
    }

}
