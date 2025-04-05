package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA5656_벽돌깨기 {

    static int N, M, num, minCnt;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            num = sc.nextInt();
            M = sc.nextInt();
            N = sc.nextInt();
            minCnt = Integer.MAX_VALUE;

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            // 입력 받음

            drop(0, map);
            System.out.println("#" + t + " " + minCnt);
        }   // 테스트케이스
    }   // 메인

    // 구슬 떨어뜨릴 곳 고르기
    private static void drop(int depth, int[][] curMap) {
        if (depth == num) {
            // 남은 벽돌 수 세고 최솟값 갱신
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (curMap[i][j] != 0) cnt++;
                }
            }

            minCnt = Math.min(cnt, minCnt);
            return;
        }

        for (int j = 0; j < M; j++) {
            int i = 0;
            while (i < N && curMap[i][j] == 0) i++;

            if (i == N) {
                drop(depth + 1, curMap);
            } else {
                int[][] copied = copyMap(curMap);
                smash(i, j, copied);
                gravity(copied);
                drop(depth + 1, copied);
            }
        }

    }


    // 벽돌 깨기 
    private static void smash(int i, int j, int[][] map) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, map[i][j]});
        map[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                for (int p = 1; p < cur[2]; p++) {
                    int nx = cur[0] + dx[d] * p;
                    int ny = cur[1] + dy[d] * p;

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0) continue;

                    if (map[nx][ny] > 1) {
                        queue.offer(new int[]{nx, ny, map[nx][ny]});
                    }
                    map[nx][ny] = 0;
                }
            }

        }

    }

    // 벽돌 끌어내리기
    private static void gravity(int[][] map) {
        for (int j = 0; j < M; j++) {
            int toFill = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    map[toFill--][j] = map[i][j];
                }
            }
            while (toFill >= 0) {
                map[toFill--][j] = 0;
            }
        }

    }

    // 임시로 시뮬레이션 돌릴 map 복사
    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }


}
