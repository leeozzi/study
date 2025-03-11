package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2606_바이러스 {

    static List<List<Integer>> arr;
    static boolean[] vis;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 컴퓨터 수
        int M = Integer.parseInt(br.readLine());    // 간선 수
        arr = new ArrayList<>();
        vis = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            arr.get(A).add(B);
            arr.get(B).add(A);
        }
//        System.out.println(arr);

        dfs(1);
        System.out.println(cnt - 1);
    }

    private static void dfs(int start) {
//        System.out.println(start + "로 들어옴");
        vis[start] = true;
        cnt++;
        for (int i = 0; i < arr.get(start).size(); i++) {
            if (!vis[arr.get(start).get(i)])
                dfs(arr.get(start).get(i));
        }
    }
}
