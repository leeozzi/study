package BOJ;

import java.util.*;

/**
 * 숨바꼭질 2
 * <a href="https://acmicpc.net/problem/12851">...</a>
 */

public class BOJ12851_숨바꼭질2 {

    static List<List<Integer>> graph;
    static int[] dist = new int[100001];
    static int N, K, cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Arrays.fill(dist, -1);
        dist[N] = 0;

        graph = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            graph.add(new ArrayList<>());
            if (i > 0)
                graph.get(i).add(i - 1);
            if (i + 1 <= 100000)
                graph.get(i).add(i + 1);
            if (i * 2 <= 100000)
                graph.get(i).add(i * 2);
        }

        bfs(N);

        if(N == K) {
            cnt = 1;
        }

        System.out.println(dist[K]);
        System.out.println(cnt);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i : graph.get(cur)) {
                if(dist[i] == -1){
                    queue.add(i);
                    dist[i] = dist[cur] + 1;
                }else if (dist[i] == dist[cur] + 1) {
                    queue.add(i); // 다른 최단 경로
                }

                if(i  == K && dist[i] == dist[cur] + 1) {
                    cnt++;
                }
            }
        }
    }
}
