package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

public class SWEA1251_하나로 {

    static double E;
    static Node[] nodes;
    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            nodes = new Node[N];
            int[] xs = new int[N];
            int[] ys = new int[N];

            String[] input = br.readLine().split(" ");
            for (int n = 0; n < N; n++) {
                xs[n] = Integer.parseInt(input[n]);
            }
            input = br.readLine().split(" ");
            for (int n = 0; n < N; n++) {
                ys[n] = Integer.parseInt(input[n]);
            }

            for (int n = 0; n < N; n++) {
                nodes[n] = new Node(xs[n], ys[n]);
            }

            E = Double.parseDouble(br.readLine());
            // 입력 끝

            // nodes 간의 간선 전부 저장
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    pq.offer(new Edge(i, j));
                }
            }

            /*
            노드 수 - 1 개의 간선 뽑기 해줄게~
             */

            // 유니온 파인드 -> 두 원소가 같은 그룹에 속해 있는지 확인하고 다른 그룹이면 합치기 위해 사용
            // 각 노드의 부모를 저장해줄 배열
            uf = new int[N];

            for (int i = 0; i < nodes.length; i++) {
                uf[i] = i;   // 각 노드들의 부모를 자기 자신으로 세팅
            }

            double totalCost = 0;
            int pick = 0;
            while (!pq.isEmpty()) {
                Edge curEdge = pq.poll();

                // px는 출발점 노드의 부모, py는 도착점 노드의 부모
                int px = findSet(curEdge.from);
                int py = findSet(curEdge.to);

                // 사이클 검사
                if (px != py) {  // 같은 집단에 속한 애들이 아니면 == 사이클이 없으면
                    // 이 간선 뽑을게 == 두 집단 연결해줄게
                    union(px, py);
                    pick++;
                    totalCost += curEdge.cost;
                }

                if (pick == N - 1) break;

            }

            System.out.printf("#%d %d\n", t, Math.round(totalCost));
        }   // 테스트케이스
    }

    private static void union(int px, int py) {
        px = findSet(px);
        py = findSet(py);

        if(px != py) uf[py] = px;
    }

    public static int findSet(int x) {
        // 지금 부모 찾으려는 노드 compare의 부모(uf[idx])가 compare 본인이 아니면
        // 가장 위로 올라가서 조상 중에 짱을 리턴해줘
        if(uf[x] != x) uf[x] = findSet(uf[x]);
        return uf[x];
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
            long dx = nodes[from].x - nodes[to].x;
            long dy = nodes[from].y - nodes[to].y;
            this.cost = E * (dx * dx + dy * dy);
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}
