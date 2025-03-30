package BOJ;

import java.util.*;

public class BOJ1697_숨바꼭질_bfs {

    static List<List<Integer>> graph;
    static int[] dist = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

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

        System.out.println(dist[K]);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i : graph.get(cur)) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    dist[i] = dist[cur] + 1;
                }
            }
        }
    }
}
