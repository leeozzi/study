package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2468_안전영역 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int maxSafe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int water = 0;
        maxSafe = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                water = Math.max(map[i][j], water);
            }
        }
        // map 입력 받음

        while (water-- != 0) {
            int safeCnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > water) {
                        safeCnt++;
                        dfs(i, j, water);
                    }
                }
            }
            maxSafe = Math.max(safeCnt, maxSafe);
        }

        System.out.println(maxSafe);
    }

    private static void dfs(int i, int j, int water) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(!visited[nx][ny] && map[nx][ny] > water) {
                    dfs(nx, ny, water);
                }
            }
        }
    }
}
