package BOJ;

import java.io.*;
import java.util.*;

/**
 * 별자리 만들기
 * <a href="https://acmicpc.net/problem/4386">...</a>
 */

public class BOJ4386_별자리만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Star[] stars = new Star[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            stars[i] = new Star(i, Double.parseDouble(input[0]), Double.parseDouble(input[1]));
        }
        // 정점 입력 완료. 인덱스를 번호로 쓰자

        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0 ;i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i != j) {
                    graph.get(i).add(new Edge(stars[i], stars[j]));
                    graph.get(i).add(new Edge(stars[j], stars[i]));
                }
            }
        } // 간선 입력 완료

        double cost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        
        // 0번 뽑았어
        visited[0] = true;
        int pick = 1;
        pq.addAll(graph.get(0));

        while(pick < N) {
            Edge cur = pq.poll();

            if(visited[cur.toIdx]) continue;

            cost += cur.cost;
            visited[cur.toIdx] = true;
            pick++;
            pq.addAll(graph.get(cur.toIdx));
        }


        System.out.printf("%.2f", cost);
    }

    static class Edge implements Comparable<Edge> {
        int fromIdx, toIdx;
        Star from, to;
        double cost;

        public Edge(Star from, Star to) {
            this.from = from;
            this.to = to;

            fromIdx = from.idx;
            toIdx = to.idx;

            double gapX = Math.abs(to.x - from.x);
            double gapY = Math.abs(to.y - from.y);
            cost = Math.sqrt(gapX * gapX + gapY * gapY);
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost - o.cost < 0) {
                return -1;
            } else if (this.cost == o.cost) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    static class Star {
        int idx;
        double x, y;

        public Star(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
}
