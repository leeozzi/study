package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ABCDE
public class BOJ13023_ABCDE_수인 {

    static boolean[] visited;
    static int n, m;
    static List<Integer>[] arr;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        flag = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 1, 5);
            if (flag)
                break;
        }
        if (flag)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static void dfs(int start, int depth, int goalNum) {

        if (depth == goalNum) {
            flag = true;
            return;
        }

        visited[start] = true;
        for (int num : arr[start])
            if (!visited[num]) {
                dfs(num, depth + 1, goalNum);
                if (flag)
                    return;
            }
        visited[start] = false;
    }
}
