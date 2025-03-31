package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2458_키순서 {

    static int N, M;
    static List<List<Integer>> graph1;  // 나보다 작은 사람
    static List<List<Integer>> graph2;  // 나보다 큰 사람
    static boolean[] vis;
    static int[] know;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();
        know = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph1.get(b).add(a);   // a가 b보다 작다
            graph2.get(a).add(b);   // a는 b보다 크다
        }

        for (int i = 1; i <= N; i++) {
            vis = new boolean[N + 1];
            bfs(i);
        }

        int cnt = 0;
        for(int i= 0 ;i < know.length; i++) {
            if(know[i] == N) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        vis[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            know[start]++;

            for (int next : graph1.get(cur)) {
                if (!vis[next]) {
                    queue.offer(next);
                    vis[next] = true;
                }
            }
        }

        vis = new boolean[N + 1];

        queue.add(start);
        vis[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            know[start]++;

            for(int next : graph2.get(cur)) {
                if(!vis[next]) {
                    queue.offer(next);
                    vis[next] = true;
                }
            }
        }

        know[start]--;
    }
}
