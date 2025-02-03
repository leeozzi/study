package Study.algorithm_study;

import java.io.*;
import java.util.*;

/**
 * 불
 * <a href="https://www.acmicpc.net/problem/5427">...</a>
 */

public class BOJ5427 {

    static Queue<Integer[]> queue; // queue에는 불 위치랑 불이 번질 위치
    static Stack<Integer[]> stack; // stack은 상근이의 이동경로

    static boolean flagBlocked = false;   // 사방이 다 막힌 경우에는 종료해주기 위한 플래그
    static boolean flagExit = false;    // 맵 벗어나면 종료해주기 위한 플래그

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            System.out.println("=======================================");


            // queue랑 stack 새로 만들어주기
            queue = new LinkedList<>();
            stack = new Stack<>();

            // map 만들기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int n = h;
            int m = w;

            // tc마다 cnt랑 min 갱신
            cnt = 0;
            int min = n*m;

            char[][] map = new char[n][m];
            int[][] visited = new int[n][m];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            // map 세팅
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
            }   // map 세팅 끝


            // 한 가지 루트 끝날 때마다 초기 상태의 map과 visited로 돌아가서 다른 루트 카운트
            int i = 1;
            while (!stack.isEmpty()) {
                // 더 갈 수 있는 데가 없거나, 탈출하면 한 가지 루트 끝난 거임
                fire(map, visited);
                move(map, visited);

                if(flagBlocked && flagExit) {
                    min = Math.min(min, cnt);

                    flagExit = false;
                    flagBlocked = false;

                    System.out.println(i++ + "번째 루트가 끝났습니다");
                    System.out.println(cnt + "를 0으로 초기화합니다");
                    cnt = 0;
                }
            }


            if(min < n*m) {
                System.out.println("현재 min은 " + min + "입니다.");
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }   // main 함수

    // 불의 이동경로 -> bfs 로 써야 한 번에 퍼뜨릴 수 있음
    public static void fire(char[][] map, int[][] visited) {
        for (int i = 0; i < queue.size(); i++) {
            Integer[] fireCur = queue.poll();

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int j = 0; j < 4; j++) {
                int nx = fireCur[0] + dx[j];
                int ny = fireCur[1] + dy[j];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if (visited[nx][ny] != 1) {
                        Integer[] next = {nx, ny};
                        queue.add(next);
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
    }

    // 상근이의 이동경로 -> dfs 로 넣어줘야 끝까지 갈 수 있음
    public static void move(char[][] map, int[][] visited) {
        Integer[] cur = stack.pop();
        System.out.println(cur[0] + " " + cur[1]);
        cnt++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if (visited[nx][ny] != 1) {
                    Integer[] next = {nx, ny};
                    stack.add(next);
                    System.out.println("방금 stack에 {" + nx + " " + ny + "} 추가함");
                    visited[nx][ny] = 1;
                    flagBlocked = true;    // 다음에 갈 수 있는 곳이 하나라도 있으면 true
                }
            } else {
                flagExit = true;    // nx, ny가 위 범위를 벗어났다는 말은 내가 끝자락에 다왔다는 얘기
            }
        }
    }

}
