package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 연결 요소의 개수
 * <a href="https://www.acmicpc.net/problem/11724">...</a>
 */
public class BOJ11724_연결요소의개수 {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < list.get(i).size(); j++) {
            if (!visited[list.get(i).get(j)]) {
                dfs(list.get(i).get(j));
            }
        }
    }
}
