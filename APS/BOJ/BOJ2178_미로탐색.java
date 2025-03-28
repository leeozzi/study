package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178_미로탐색 {

    static int N, M, dist;
    static int[][] map, dp;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input= br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visit = new boolean[N][M];
        dp = new int[N][M];

        for(int i = 0 ;i  < N ; i++) {
            input = br.readLine().split("");
            for(int j = 0 ;j < M ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = 1;
        bfs(0, 0);

        System.out.println(dp[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visit[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == N-1 && cur[1] == M-1) return;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + cur[0];
                int ny = dy[d] + cur[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                        dp[nx][ny] += dp[cur[0]][cur[1]] +1;
                    }
                }
            }
        }
    }
}
