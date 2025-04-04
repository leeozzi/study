package SWEA;

import java.util.*;

public class SWEA1949_등산로조성 {
    /**
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq">...</a>
     */

    static int n, k, maxDepth;
    static boolean flag;
    static int[][] map, copyMap;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            k = sc.nextInt();

            map = new int[n][n];
            copyMap = new int[n][n];
            int startPoint = 0;
            maxDepth = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                    copyMap[i][j] = map[i][j];
                    startPoint = Math.max(startPoint, map[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == startPoint) {
//                        System.out.println("========================");
                        for (int x = 0; x < n; x++) {
                            copyMap[x] = Arrays.copyOf(map[x], n);
                        }
                        flag = false;
                        visited = new boolean[n][n];
                        dfs(i, j, 1, k);
                    }
                }
            }

            System.out.printf("#%d %d\n", t, maxDepth);
        }
    }

    private static void dfs(int i, int j, int depth, int cons) {
//        System.out.println("===== "+i + "," + j + " depth :" + depth + " maxDepth :" + maxDepth);

        visited[i][j] = true;
        maxDepth = Math.max(depth, maxDepth);

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
//                System.out.println(nx + "," + ny + " 다음에 갈 수 있는지 검사");
                if (copyMap[nx][ny] < copyMap[i][j] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, cons);
                    visited[nx][ny] = false;
                } else if (copyMap[nx][ny] >= copyMap[i][j] && !visited[nx][ny] && !flag) {
                    while (copyMap[nx][ny] >= copyMap[i][j] && cons > 0) {
                        cons--;
                        --copyMap[nx][ny];
                        flag = true;
                    }

//                    System.out.println("깎고 나옴 " + nx + "," + ny + " = " + copyMap[nx][ny]);

                    if (copyMap[nx][ny] < copyMap[i][j]) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, depth + 1, k);
                        visited[nx][ny] = false;
                    }

                    cons = k;
                    copyMap[nx][ny] = map[nx][ny];
                    flag = false;
                }
            }
        }
    }
}
