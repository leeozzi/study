package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정한 최단 경로
 * https://www.acmicpc.net/problem/1504
 */

public class BOJ1504_특정한최단경로 {

    static class Edge {
        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "(" + to + "," + distance + ')';
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] vis;
    static int N, v1, v2;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        vis = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(graph);

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        //////////////////////////////////////////////////////////

        bfs(1, v1, v2);

    }   // 메인함수

    public static void bfs(int start, int dest, int next) {
        if(start == N) return;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
            if (cur == dest) {
                bfs(dest, next, N);
                return;
            }

            List<Edge> edges = graph.get(cur);
            for (int i = 0; i < edges.size(); i++) {
                if (!vis[edges.get(i).to]) {
                    queue.add(edges.get(i).to);
                }
            }
        }
    }
}
