package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1197_최소스패닝트리_크루스칼 {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            edges.add(new Edge(from, to, cost));
        }

        Collections.sort(edges);

        // V-1개 간선 뽑기
        // 유니온파인드
        p = new int[V+1];

        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }

        long ans = 0;
        int pick = 0;
        for(int i = 0 ;i < E ;i++) {
            int px = findSet(edges.get(i).from);
            int py = findSet(edges.get(i).to);

            if(px != py) {
                union(px, py);
                pick++;
                ans += edges.get(i).cost;
            }

            if(pick == V-1) break;
        }

        System.out.println(ans);



    }

    private static void union(int x, int y) {
        p[y] = x;
    }

    private static int findSet(int X) {
        if(p[X] != X) p[X] = findSet(p[X]);
        return p[X];
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
