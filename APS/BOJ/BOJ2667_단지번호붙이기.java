package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667_단지번호붙이기 {

    static int N;
    static int[][] map;
    static boolean[][] vis;
    static int max = 0;
    static int group = 0, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 입력 받기 끝

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    group++;
                    cnt = 1;
                    dfs(i, j);
                    res.add(cnt);
                }
            }
        }

        System.out.println(group);
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

    private static void dfs(int i, int j) {
        vis[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = dx[d] + i;
            int ny = dy[d] + j;

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !vis[nx][ny]) {
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
