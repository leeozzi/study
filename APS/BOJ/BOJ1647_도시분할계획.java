package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 도시 분할 계획
 * <a href="https://acmicpc.net/problem/1647">...</a>
 */

public class BOJ1647_도시분할계획 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        List<List<Edge>> graph = new ArrayList<>();

        // 그래프 만들기
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
//        System.out.println(graph);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int ans = 0;
        int maxCost = 0;

        int pick = 1;
        visited[1] = true;
        pq.addAll(graph.get(1));
//        System.out.println(1);

        while(pick < N) {
            Edge e = pq.poll();
            if(visited[e.to]) continue;

            ans+= e.cost;
            pick++;
            visited[e.to] = true;
            pq.addAll(graph.get(e.to));
            maxCost = Math.max(e.cost, maxCost);
        }

        System.out.println(ans - maxCost);
        // 어차피 사이클 없으니까 그냥 최대 비용인 간선 하나 빼주면 되는 거 아님?
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
            return to + "(" + cost + ")";
        }
    }
}
