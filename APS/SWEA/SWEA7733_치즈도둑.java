package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA7733_치즈도둑 {

    static int N;
    static int[][] map;
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int max = 0;

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            vis = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            // 입력 받음

            for(int days = 0 ; days < 100 ; days++) {

                vis = new boolean[N][N];

                int group = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j] <= days) {
                            vis[i][j] = true;
                        }   // 요정이 먹었어

                        else if (!vis[i][j]) {
                            group++;
                            dfs(i, j, days);
                        }
                    }
                }   // 그룹 수 세기

                max = Math.max(group, max);

            }   // 100일 지남

            System.out.printf("#%d %d\n", t, max);


        }
    }

    private static void dfs(int i, int j, int days) {

        vis[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {

            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!vis[nx][ny]) {
                    if (map[nx][ny] <= days) {
                        vis[nx][ny] = true;
                    } else {
                        dfs(nx, ny, days);
                    }
                }
            }
        }
    }
}
