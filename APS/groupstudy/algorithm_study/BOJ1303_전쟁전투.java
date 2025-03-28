package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1303_전쟁전투 {
    static char[][] map;
    static boolean[][] vis;
    static int N, M;
    static int cntW = 0, cntB = 0, teamW = 0, teamB = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        N = b;
        M = a;
        map = new char[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // 입력 받음

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!vis[i][j]) {
                    cntW = 0;
                    cntB = 0;
                    dfs(i, j);
                    teamW += (int) Math.pow(cntW, 2);
                    teamB += (int) Math.pow(cntB, 2);
                }
            }
        }

        System.out.println(teamW + " " + teamB);
    }

    private static void dfs(int i, int j) {

        vis[i][j] = true;
        if(map[i][j] == 'W') cntW++;
        else cntB++;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int d = 0 ; d < 4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(!vis[nx][ny] && map[i][j] == map[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}
