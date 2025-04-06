package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ25511_값이k인트리노드의깊이 {

    static int n, k;
    static List<List<Integer>> graph;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); // 노드 개수
        k = Integer.parseInt(input[1]); // 목표

        // 노드 입력
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < n - 1; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
        }

        // 노드에 부여된 값 입력
        input = br.readLine().split(" ");
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(input[i]);
        }

        dfs(0, 0);
    }

    private static void dfs(int i, int depth) {
        if(values[i] == k) {
            System.out.println(depth);
            return;
        }

        for (int next : graph.get(i)) {
            dfs(next, depth + 1);
        }

    }
}
