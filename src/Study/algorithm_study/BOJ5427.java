package Study.algorithm_study;

import java.io.*;
import java.util.*;

/**
 * 불
 * <a href="https://www.acmicpc.net/problem/5427">...</a>
 */

public class BOJ5427 {

    static char[][] map;
    static int[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // map 만들기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // 상근이 위치 찾기 + 벽 위치 못 가게 visited 체크로 막기
            int x = -1;
            int y = -1;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        x = i;
                        y = j;
                    } else if (map[i][j] == '#') {
                        visited[i][j] = 1;
                    }
                }
            }

            // 불 위치 찾기


        }
    }

    private static void bfs(int i, int j) {
        // 불 퍼뜨리기 : 불 위치 찾아서 bfs 돌리기
        // 상근이 옮기기

        // 불이 한 칸 뻗어나갈 때마다 상근이도 같이 옮겨줘야 해
        // bfs 끝나고 나서 상근이 옮기지 않게 주의

        // 상근이 이동할 때마다 cnt++;
    }
}
