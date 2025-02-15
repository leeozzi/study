package workingon;

import java.io.*;
import java.util.*;

public class BOJ5427_불_2 {

    static char[][] map;
    static int[][] visited;
    static List<Integer[]> firelocations;
    static List<Integer[]> escapelocations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // map 만들기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int n = h;
            int m = w;

            map = new char[n][m];
            visited = new int[n][m];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            firelocations = new LinkedList<>();            // 불 위치 리스트
            escapelocations = new ArrayList<>();            // 탈출구 위치 리스트

            // map 세팅
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '@') { //  상근이 위치
                        Integer[] cur = {i, j};
                    } else if (map[i][j] == '*') {  // 불 위치
                        Integer[] fire = {i, j};
                        firelocations.add(fire);
                    } else if (map[i][j] == '#') {   // 벽 위치
                        visited[i][j] = 1;
                    } else if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && map[i][j] == '.') {    // 탈출구 위치
                        escapelocations.add(new Integer[]{i, j});
                    }
                }
            }   // map 세팅 끝


        }
    }   // main


    public static void fire() { // 이거 한 번 돌고 나면 불 동시에 한 칸씩 번짐
        for (int i = 0; i < firelocations.size(); i++) {
            int r = firelocations.get(i)[0];
            int c = firelocations.get(i)[1];

            // 사방탐색
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int j = 0; j < 4; j++) {
                int nx = r + dx[j];
                int ny = c + dy[j];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (visited[nx][ny] == 0) {
                        firelocations.add(new Integer[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }

            // 퍼질 수 있는 불만 담아주면 되니까 퍼뜨리고 나면 지워주기
            firelocations.remove(firelocations.get(i));
        }

    }

}

