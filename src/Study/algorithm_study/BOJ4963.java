package Study.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    /**
     * 섬의 개수
     * <a href="https://www.acmicpc.net/problem/4963">...</a>
     */

    static int[][] map;
    static Queue<Integer[]> queue;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line);

            // map 만들기
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            queue = new LinkedList<>(); // Queue는 새로운 map 생성할 때마다 만들어주기
            visited = new int[h][w];    // visited도 이하동문
            int cnt = 0;    // cnt 도 매번 새로 세 줘야 함

            // map에서 1 찾기 -> 찾으면 bfs 돌려주기
            // 0 찾아도 한 번 만난 애들은 visited 1로 돌려주기
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] != 1) {
                        cnt++;
                        bfs(i, j);
                    } else if (map[i][j] == 0 && visited[i][j] != 1) {
                        visited[i][j] = 1;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int i, int j) {
        // 일단 내 위치 visited 체크해주고
        visited[i][j] = 1;

        // 팔방탐색할 벡터값
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        // 주변탐색하면서 1인 친구들 Queue에 넣어주고 visited 체크해주기
        for (int l = 0; l < 8; l++) {
            int nx = i + dx[l];
            int ny = j + dy[l];

            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[i].length) {
                if (map[nx][ny] == 1 && visited[nx][ny] != 1) {
                    Integer[] location = {nx, ny};
                    queue.add(location);
                    visited[nx][ny] = 1;
                }
            }
        }

        // queue에서 poll 해서 queue 빌 때까지 bfs해주기
        while (!queue.isEmpty()) {
            Integer[] next = queue.poll();
            bfs(next[0], next[1]);
        }
    }
}
