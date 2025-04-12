package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18290_NM과K1 {
    static int N, M, K, maxSum;
    static int[][] map, visited, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[K][2];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 받음

        maxSum = Integer.MIN_VALUE;
        pick(0, 0, 0);
        System.out.println(maxSum);
    }

    public static void pick(int r, int index, int sum) {

        if (index == K) {
            maxSum = Math.max(sum, maxSum);
            return;
        }


        for (int c = r; c < N * M; c++) {
            int i = c / M;
            int j = c % M;

            if (visited[i][j] == 0) {
                result[index] = new int[]{i, j};
                sum += map[i][j];
                checkAdjacent(i, j, 1);

                pick(c + 1, index + 1, sum);

                sum -= map[i][j];
                checkAdjacent(i, j, -1);
            }
        }

    }

    public static void checkAdjacent(int r, int c, int check) {

        visited[r][c] += check;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int d = 0; d < 4; d++) {
            int nx = dx[d] + r;
            int ny = dy[d] + c;

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            visited[nx][ny] += check;
        }
    }
}
