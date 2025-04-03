package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 서강 그라운드
 * <a href="https://www.acmicpc.net/problem/14938">...</a>
 */

/*
1. 각 노드를 시작점으로 하는 전체 노드의 최단 거리를 구하고
2. 그 중에서 시작점 아이템 + 거리가 r 이하인 애들 아이템 먹어주기
3. MaxItem 갱신
 */

public class BOJ14938_서강그라운드 {

    static int n, m, r ;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] items;
    static int maxItem = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");
        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(input[i-1]);
        }
//        System.out.println(Arrays.toString(items));

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        for(int i = 1 ; i <= n ; i++) {
            dijkstra(i);
        }

        System.out.println(maxItem);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int itemCnt = 0;

        pq.offer(new Edge(start, 0));
        dist[start] = 0;

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

//        System.out.println(start + "로 시작했을 때 dist : " + Arrays.toString(dist));

        for (int i = 1; i <= n; i++) {
            if(dist[i] <= m) {
                itemCnt += items[i];
            }
        }

        maxItem = Math.max(maxItem, itemCnt);
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
