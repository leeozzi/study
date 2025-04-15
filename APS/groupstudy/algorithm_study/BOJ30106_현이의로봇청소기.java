package groupstudy.algorithm_study;

import java.util.*;
import java.io.*;

public class BOJ30106_현이의로봇청소기 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 받음

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    ++cnt;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int i, int j) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        visited[i][j] = true;

        for(int d = 0 ; d < 4 ; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if(!visited[nx][ny] && Math.abs(map[i][j] - map[nx][ny]) <= K) {
                dfs(nx, ny);
            }

        }


    }

}
