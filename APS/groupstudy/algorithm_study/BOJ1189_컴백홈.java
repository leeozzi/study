package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1189_컴백홈 {

    static int N, M, K, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        // 입력

        dfs(N - 1, 0, 1);

        System.out.println(cnt);
    }

    private static void dfs(int i, int j, int depth) {
        if(depth > K) return;

        if (i == 0 && j == M - 1) {
            if (depth == K) cnt++;
            return;
        }

        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (map[nx][ny] != 'T' && !visited[nx][ny]) {
                dfs(nx, ny, depth + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
