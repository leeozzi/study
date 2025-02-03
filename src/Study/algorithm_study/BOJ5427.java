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
    static int cnt;
    static int min;

    // queue에는 불 위치랑 불이 번질 위치 담아줄 거야...
    static Queue<Integer[]> queue = new LinkedList<>();

    // stack은 상근이의 이동경로
    static Stack<Integer[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // tc마다 cnt랑 min 갱신
            cnt = 0;
            min = 0;

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

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '@') {
                        // 상근이 위치 저장
                        Integer[] cur = {i, j};
                        stack.add(cur);
                    } else if (map[i][j] == '*') {   // 최초 불 위치 queue에 넣어주기
                        Integer[] fire = {i, j};
                        queue.add(fire);
                        visited[i][j] = 1;
                    } else if (map[i][j] == '#') {   // 벽 설치
                        visited[i][j] = 1;
                    }
                }
            }

            // reset할 때 줄 default map
            char[][] defaultMap = map;


            while (true) {
                // stack이 비면 완전히 모든 경로 탐색 끝난 거야.
                if (stack.isEmpty()) {
                    if (min > 0) {
                        System.out.println(min);
                        break;
                    } else {
                        System.out.println("IMPOSSIBLE");
                        break;
                    }
                }

                play(defaultMap);
            }

        }
    }

    private static void play(char[][] defaultMap) {
        bfs(defaultMap);
        if(!stack.isEmpty()) move(defaultMap, stack.pop());
    }


    private static void bfs(char[][] map) { // 상근이 위치 받아오기
        Integer[] fire = queue.poll();

        // 사방탐색 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 불 사방으로 번지기 (번질 수 있는 공간이 남아있을 때만)
        if (fire != null) {
            for (int i = 0; i < 4; i++) {
                int nx = fire[0] + dx[i];
                int ny = fire[1] + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                    if (visited[nx][ny] != 1) {
                        queue.poll();
                        Integer[] spread = {nx, ny};
                        queue.add(spread);
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
    }

    private static void move(char[][] map, Integer[] cur) {
        // 얘는 dfs 써야할 것 같음
        // 사방탐색 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 바로 다음 턴에 갈 수 있는 위치들을 stack에 넣어주기
        for (int i = 0; i < 4; i++) {
            boolean flag = false;
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                if (visited[nx][ny] != 1) {
                    Integer[] next = {nx, ny};
                    if (visited[nx][ny] != 1) {
                        stack.add(next);
                        flag = true;
                        // 사방 탐색하면서 하나라도 추가 가능한 거 발견하면 true로 돌려줌
                    }
                }

                // 아직 맵 안 벗어나는데 사방 가로막히면 죽은 거
                // -> 이 가로막힌 걸 알 수 있게 flag 심어주자
                // 죽고 나면...
                // 그 다음 stack에 있는 애 즉, 아까 가능했는데 선택하지 않았던 애한테 가겠지?
                // 그럼 다시 리셋해줘야 해.
                if (flag == false) {
                    play(map);
                }


            } else {    // nx나 ny가 map 범위 벗어나면 일단 min 저장해주고
                min = Math.min(min, cnt);
                // 이 stack에 남은 건 계속 가져가면서
                // map이랑 visited는 리셋해줘야 함
                play(map);
            }
        }
    }
}
