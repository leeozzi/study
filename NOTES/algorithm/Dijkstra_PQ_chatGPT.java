package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_PQ_chatGPT {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 5;  // 노드 개수
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 5));
        graph.get(2).add(new Edge(3, 1));
        graph.get(3).add(new Edge(4, 3));

        int[] dist = new int[n+1];  // 비용 저장해줄 배열
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        // 다익스트라
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            // 내가 가려는 곳에 이미 저장된 비용이 
            // 나한테서 걔한테 가는 비용보다 작다면 건너뜀
            // (나를 거치는 게 더 비싸다는 뜻)
            if(dist[cur.to] < cur.cost) continue;

            // 그렇지 않다면
            // 현재 정점과 연결된 인접 정점들 순회
            for(Edge next :graph.get(cur.to)) {
                // cur.to : 현재 정점 , graph.get(cur.to) : 나랑 연결된 이웃 정점들
                // 현재 정점(cur.to)를 거쳐서 이웃 정점으로 가는 경로가 
                // 기존에 알고 있던 거리(dist[next.to])보다 짧다면 거리 갱신
                if(dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        // 모든 정점까지의 최단거리 출력
        for(int i = 1; i <= n ; i++) {
            System.out.println(i +"번까지 최단 거리: " + dist[i]);
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
