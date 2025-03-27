package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA7465_창용마을무리의개수 {

    static List<List<Integer>> list;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            list = new LinkedList<>();

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // 노드의 개수
            int M = Integer.parseInt(input[1]); // 간선의 개수

            for (int i = 0; i < N + 1; i++) {
                list.add(new ArrayList<>());
            }
            vis = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                list.get(a).add(b);
                list.get(b).add(a);
            }

            int group = 0;
            for (int i = 1; i < N + 1; i++) {
                if (!vis[i]) {
                    group++;
                    dfs(i);
                }
            }

            System.out.printf("#%d %d\n", t, group);
        }   // 테스트케이스
    }

    private static void dfs(int cur) {
        vis[cur] = true;
        List<Integer> friends = list.get(cur);

        for (int i = 0; i < friends.size(); i++) {
            int next = friends.get(i);
            if(!vis[next]) {
                dfs(next);
            }
        }

    }

}
