package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1238_Contact {

    static List<Set<Integer>> list;
    static boolean[] visit;
    static int[] dist;
    static int max, maxIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int start = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            // 연락할 수 있는 애들 리스트
            list = new LinkedList<>();
            for (int i = 0; i < 101; i++) {
                list.add(new HashSet<>());
            }
            visit = new boolean[101];
            dist = new int[101];
            
            // 간선 입력
            for (int i = 0; i < N - 1; i += 2) {
                int A = Integer.parseInt(input[i]);
                int B = Integer.parseInt(input[i + 1]);
                list.get(A).add(B);
            }

            max = 0;
            maxIdx = -1;

            dist[start] = 1;
            bfs(start);
            for(int i = 0; i < dist.length ;i++) {
                if(dist[i] == max) {
                    maxIdx = Math.max(maxIdx, i);
                }
            }

            System.out.printf("#%d %d\n", t, maxIdx);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visit[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int friend : list.get(cur)) {
                if(!visit[friend]) {
                    visit[friend] = true;
                    queue.add(friend);
                    dist[friend] = dist[cur] + 1;
                    max = Math.max(dist[friend], max);
                }
            }
        }


    }
}
