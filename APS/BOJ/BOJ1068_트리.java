package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://www.acmicpc.net/problem/1068">...</a>
 */

public class BOJ1068_트리 {
    static int N, remove, cnt;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        int head = -1;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(input[i]);
            if (p != -1) {
                graph.get(p).add(i);
            } else {
                head = i;
            }
        }
        remove = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if(graph.get(i).contains(remove)) {
                graph.get(i).remove(Integer.valueOf(remove));
            }
        }
        graph.get(remove).clear();

        if(remove == head) {
            System.out.println(0);
            return;
        }

        bfs(head);
        System.out.println(cnt);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
//            System.out.println("cur : " + cur);
            boolean flag = false;

            for (int next : graph.get(cur)) {
//                System.out.println("next : " + next);
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    flag = true;
                }
            }

            if(!flag) {
                cnt++;
//                System.out.println(cur + "에서 cnt ++ => " +cnt);
            }
        }
    }
}
