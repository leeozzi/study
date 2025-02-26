package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ31575_도시와비트코인 {
    /**
     * 도시와 비트코인
     * <a href="https://www.acmicpc.net/problem/31575">...</a>
     */

    static int[][] map;
    static boolean[][] visited;
    static boolean res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[0]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 입력 끝 //

        dfs(0, 0);
        visited[0][0] = true;
        if(res) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void dfs(int i, int j) {
        if(i == map.length-1 && j == map[i].length-1) {
            res = true;
            return;
        }

        int[] dx = {0, 1};  // 동, 남
        int[] dy = {1, 0};

        for (int d = 0; d < 2; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
//                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
