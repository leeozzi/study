package workingon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
 */

/*
1. 가능한 위치에 떨어뜨려본다
-- 함수 --
2. 열 삭제, 행 삭제 - 하기 전에 그 사이즈 더해주기
3. 구슬 n개 반복하는 동안 다 더하고 max 갱신
--
4. 구슬 위치마다 1 ~ 3 반복

visited 배열...
 */

public class SWEA5656_벽돌깨기 {

    static int num, N, M;
    static int[][] map;
    static boolean[] visited;
    static int cnt, maxCnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            num = sc.nextInt();
            M = sc.nextInt();
            N = sc.nextInt();

            map = new int[N][M];
            visited = new boolean[M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            // 입력 받음

            for (int i = 0; i < M; i++) {
                System.out.println("=================");
                visited[i] = true;
                dfs(i, 0);
                visited[i] = false;
            }

        }   // 테스트케이스
    }   // 메인

    private static void dfs(int drop, int depth) {
        if(depth == num) {
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }

        for(int d = 0 ; d < 4 ; d++) {

        }

    }
}
