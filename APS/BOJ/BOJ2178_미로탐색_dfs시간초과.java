package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2178_미로탐색_dfs시간초과 {
    static int N, M, dist = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0, 1);


        System.out.println(dist);

    }

    private static void dfs(int i, int j, int depth) {
        visited[i][j] = true;

        if(i == N-1 && j == M-1) {
            dist = Math.min(depth, dist);
            return;
        }


        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny, depth + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
