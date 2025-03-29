package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2105_디저트카페 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            // 입력 받았음

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(i, j, i, j, 0, 0);
                }
            }


        }   // 테스트케이스
    }

    private static void dfs(int startX, int startY, int curX, int curY, int dir, int cnt) {
        visited[curX][curY] = true;

        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, -1, 1};

        int nx = curX + dx[dir];
        int ny = curY + dy[dir];

        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            if(!visited[nx][ny]){
                dfs(startX, startY, nx, ny, dir+1, cnt+1);
            }
        }
    }

    private static void noSameDessert(int x, int y) {
        int dessert = map[x][y];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == dessert) {
                    visited[i][j] = true;
                }
            }
        }
    }

}
