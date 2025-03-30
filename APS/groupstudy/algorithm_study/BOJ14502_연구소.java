package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

/**
 * 연구소
 * <a href="https://acmicpc.net/problem/14502">...</a>
 */

public class BOJ14502_연구소 {

    static int N, M, ans = 0;
    static int[][] map;
    static boolean[][] walls, infected;
    static List<int[]> viruses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        infected = new boolean[N][M];
        walls = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    walls[i][j] = true;
                } else if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        // 입력 완료

        buildWall(0);
        System.out.println(ans);
    }   // main 함수

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            infected[curX][curY] = true;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!walls[nx][ny] && map[nx][ny] == 0 && !infected[nx][ny]) {
                        infected[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void buildWall(int wallcnt) {
        if (wallcnt == 3) {   // 벽 세 개 다 세우면
            // infected 초기화
            infected = new boolean[N][M];

//            while (!queue.isEmpty()) {    // 바이러스 다 퍼뜨려주고
//                int[] virus = queue.poll();
//                bfs(virus[0], virus[1]);
//            }

            for (int i = 0; i < viruses.size(); i++) {
                int[] virus = viruses.get(i);
                bfs(virus[0], virus[1]);
            }

            // 안전영역 개수 세어줄거
            int safe = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!walls[i][j] && !infected[i][j] && map[i][j] == 0) safe++;
                }
            }

            // 안전영역 최댓값 갱신
            ans = Math.max(ans, safe);

//            // 테스트 출력
//            System.out.println("=====벽 위치====");
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    if (walls[i][j]) {
//                        System.out.print("W ");
//                    } else if (infected[i][j] || map[i][j] == 2) {
//                        System.out.print("X ");
//                    } else {
//                        System.out.print("○ ");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println();
//            // 테스트 출력

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!walls[i][j] && map[i][j] == 0) {
                    walls[i][j] = true;
                    buildWall(wallcnt + 1);
                    walls[i][j] = false;
                }
            }
        }
    }
}
