package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWEA2105_디저트카페 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max;
    static Set<Integer> desserts = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            max = -1;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            // 입력 받았음

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
//                    System.out.println("=================");
                    visited = new boolean[N][N];
                    desserts.clear();

                    visited[i][j] = true;               // 시작 좌표 방문 처리
                    desserts.add(map[i][j]);           // 시작 좌표 디저트 종류 추가

                    dfs(i, j, i, j, 0, 0);
                }
            }

            System.out.printf("#%d %d\n", t, max);

        }   // 테스트케이스
    }

    private static void dfs(int startX, int startY, int curX, int curY, int dir, int cnt) {
//        System.out.println("start : " + startX + "," + startY + " cur : " + curX + "," + curY + " dir: " + dir + " max : " + max + " cnt : " + cnt);
//        System.out.println(desserts);
        if (cnt >= 3 && curX == startX && curY == startY) {
            max = Math.max(max, cnt + 1);
//            System.out.println("max 갱신됨");
            return;
        }
        if (dir >= 4) {
//            System.out.println("방향 다 돌았음");
            return;
        }

//        visited[curX][curY] = true;
//        desserts.add(map[curX][curY]);

        // 오른쪽아래, 왼쪽아래, 왼쪽위, 오른쪽위
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, -1, 1};

        int nx = curX + dx[dir];
        int ny = curY + dy[dir];

        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            if (!visited[nx][ny] && !desserts.contains(map[nx][ny])) {
                visited[nx][ny] = true;
                desserts.add(map[nx][ny]);

                dfs(startX, startY, nx, ny, dir, cnt + 1);
                dfs(startX, startY, nx, ny, dir + 1, cnt + 1);

                visited[nx][ny] = false;
                desserts.remove(map[nx][ny]);
            } else if (nx == startX && ny == startY && cnt >= 3) {
//                System.out.println("다음칸 시작칸이야");
                dfs(startX, startY, nx, ny, dir, cnt);
            }   // 다음 애가 시작점이라면 vis 조건이랑 contains 조건 무시하고 한 칸 더 나아가줘
        }

    }


}
