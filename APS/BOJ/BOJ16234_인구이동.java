package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 인구 이동
 * <a href="https://www.acmicpc.net/problem/16234">...</a>
 */

public class BOJ16234_인구이동 {

    static int N, L, R, sum;
    static int[][] map, newMap;
    static boolean[][] visited;
    static List<int[]> toChange;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // map 한 변 길이
        // 두 인구의 차이가 L이상 R 이하일 때 국경선 열림
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        map = new int[N][N];
        newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];    // 하루 지날 때마다 갱신해줘야 함
            boolean flag = false;
            // 일단 한 번 전체 dfs를 돌려보자 (하루 지나는 거임)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        sum = map[i][j];
                        toChange = new ArrayList<>();
                        dfs(i, j);
                        if (toChange.size() > 1) {
                            flag = true;
                        }

                        int newPpl = sum / toChange.size();
                        for (int[] change : toChange) {
                            int x = change[0];
                            int y = change[1];
                            map[x][y] = newPpl;
                        }
                    }
                }
            }

            if (!flag) {
                System.out.println(days);
                return;
            } else {
                days++;
            }
        }
    }

    public static void dfs(int i, int j) {
        toChange.add(new int[]{i, j});

        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                int gap = Math.abs(map[i][j] - map[nx][ny]);
                boolean openCondition = (gap >= L) && (gap <= R);   // 문 열리는 조건
                if (!visited[nx][ny] && openCondition) {
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                    dfs(nx, ny);
                }
            }
        }
    }
}
