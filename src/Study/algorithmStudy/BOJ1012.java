package Study.algorithmStudy;

import java.util.*;

public class BOJ1012 {

    static int[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0. 테스트케이스 입력 받기
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int worm = 0;
            // 1. 배추밭 만들기
            int M = sc.nextInt();   // 배추밭의 가로 길이
            int N = sc.nextInt();   // 배추밭의 세로 길이
            int[][] cabbage = new int[M][N];

            int K = sc.nextInt();   // 배추가 심어져 있는 위치의 개수
            for (int i = 0; i < K; i++) {
                int X = sc.nextInt();    // 배추의 행 위치
                int Y = sc.nextInt();   // 배추의 열 위치
                cabbage[X][Y] = 1;
            }

            // 2. visit 표 만들기
            visit = new int[M][N];

            // 3. 배추 밭에서 1 찾기
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] != 1 && cabbage[i][j] == 1) {
                        // 4-1. 일단 벌레수 올리고
                        worm++;
                        // 4-2. bfs
                        bfs(cabbage, visit, i, j);
                    } else if (visit[i][j] != 1 && cabbage[i][j] == 0) {    // 배추 없는 애들도 일단 한 번 탐색하면 visit 1로 돌려주기
                        visit[i][j] = 1;
                    }
                }
            }

            System.out.println(worm);

//            // cabbage 테스트 출력
//            for (int i = 0; i < cabbage.length; i++) {
//                for (int j = 0; j < cabbage[i].length; j++) {
//                    System.out.print(cabbage[i][j]);
//                }
//                System.out.println();
//            }
//
//            // visit 테스트 출력
//            for (int i = 0; i < visit.length; i++) {
//                for (int j = 0; j < visit[i].length; j++) {
//                    System.out.print(visit[i][j]);
//                }
//                System.out.println();
//            }

        }
    }

    private static void bfs(int[][] cabbage, int[][] visit, int i, int j) {
        // 4-2-1. Queue 만들기
        Queue<Integer[]> queue = new LinkedList<>();
        // 4-2-2. 현재 좌표 큐에 넣고
        Integer[] curLocation = new Integer[2];
        curLocation[0] = i;
        curLocation[1] = j;
        queue.add(curLocation);
        // 4-2-3. visit에서 해당 좌표 1로 바꾸기
        visit[i][j] = 1;
        // 4-2-4. 큐에서 좌표 꺼내기
        queue.remove(curLocation);
        // 4-2-5. 사방탐색하면서 1 찾으면 반복
        // (1) 사방탐색할 벡터값 (상 하 좌 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // (2) 사방탐색
        for (int d = 0; d < 4; d++) {
            int nx = dx[d] + i;
            int ny = dy[d] + j;
            if (nx >= 0 && nx < cabbage.length && ny >= 0 && ny < cabbage[0].length) {
                if (visit[nx][ny] != 1 && cabbage[nx][ny] == 1) {
                    bfs(cabbage, visit, nx, ny);
                }
            }
        }
    }


}
