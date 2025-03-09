package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3184_양 {

    static char[][] map;
    static boolean[][] visited;
    static int sheep = 0, wolf = 0;
    static int cntsheep, cntwolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            map[i] = chars;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                }
            }
        }

        // # 울타리, . 빈 필드, o 양, v 늑대
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (!visited[i][j]) {
//                    System.out.println(i + " " + j + "에서 dfs 들어가유");
                    cntsheep = 0;
                    cntwolf = 0;
                    dfs(i, j);

                    if (cntsheep > cntwolf) {
                        sheep += cntsheep;
                    } else {
                        wolf += cntwolf;
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void dfs(int i, int j) {
        if (map[i][j] == 'o') cntsheep++;
        else if (map[i][j] == 'v') cntwolf++;

        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[i].length) {
                if (!visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
