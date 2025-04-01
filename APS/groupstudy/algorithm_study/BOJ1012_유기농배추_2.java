package groupstudy.algorithm_study;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1012
 */

public class BOJ1012_유기농배추_2 {

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int i, int j) {

        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx < N && ny < M && nx >= 0 && ny >= 0) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
