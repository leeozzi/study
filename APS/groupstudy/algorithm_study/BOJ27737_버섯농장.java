package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27737_버섯농장 {

    static int[][] map;
    static boolean[][] vis;
    static int N, M, K;
    static int cnt0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // N*N 크기의 나무판
        M = Integer.parseInt(input[1]); // M개의 버섯포자
        K = Integer.parseInt(input[2]); // 최대 K개의 연결된 칸에 버섯 자람
        int M2 = M;

        map = new int[N][N];
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    vis[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j] && map[i][j] == 0) {
                    cnt0 = 0;
                    mushroom(i, j);

                    M2 -= cnt0 / K + (cnt0 % K == 0 ? 0 : 1);
//                    if (cnt0 % K == 0) {
//                        M2 -= cnt0 / K;
//                    } else {
//                        M2 -= (cnt0 / K + 1);
//                    }
                }
            }
        }

        if(M2 == M) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        if (M2 >= 0) {
            System.out.println("POSSIBLE");
            System.out.println(M2);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }   // main

    // 구역마다 해야하는 것
    // 0 개수 세기
    // 해당 구역에서 필요한 포자 수 0개수 % K == 0 이면 0개수/K , 아니면 0개수/K + 1
    // 전체 포자 개수에서 필요한 포자 수 빼주기

    private static void mushroom(int i, int j) {
        if (vis[i][j] || map[i][j] == 1) return;

        vis[i][j] = true;
        cnt0++;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 0 && !vis[nx][ny]) {
                    mushroom(nx, ny);
                }
            }
        }
    }
}
