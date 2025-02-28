package SWEA;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class SWEA1949_등산로조성 {

    static int[][] map;
    static boolean[][] visited;
    static Stack<int[]> stack;
    static int distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // map 만들어주기
            map = new int[N][N];
            visited = new boolean[N][N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    max = Math.max(map[i][j], max);
                }
            }

            stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        dfs(new int[]{i, j});
                    }
                }
            }


        }   // testcase
    }

    private static void dfs(int[] location) {
        int i = location[0];
        int j = location[1];
        System.out.println("cur : " + i + "," + j);

        stack.push(location);
        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                if (map[nx][ny] < map[i][j] && !visited[nx][ny]) {
                    int[] next = {nx, ny};
                    queue.add(next);
                    visited[nx][ny] = true;
                    dfs(next);
                }
            }
        }

    }
}
