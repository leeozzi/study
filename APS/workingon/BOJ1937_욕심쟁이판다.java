package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1937_욕심쟁이판다 {
    /**
     * 욕심쟁이 판다
     * <a href="https://www.acmicpc.net/problem/1937">...</a>
     */

    static int[][] board;
    static boolean[][] visited;
    static Stack<int[]> stack;
    static int max;
    static HashMap<String, Integer> hashmap = new HashMap<>();  // 그 칸까지 온 거리 리턴할 것

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 대나무숲의 크기 최대 500
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }   // board 입력 받기 - 대나무의 양은 백만 이하

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("============NEW 반복문!!!!=============");
//                hashmap.clear();
                stack = new Stack<>();
                dfs(i, j, 1);
            }
        }

        System.out.println(max);

    }

    public static int dfs(int i, int j, int depth) {

        System.out.println("**함수 입장**");
        System.out.println("현재 함수 인자로 들어온 친구 : " + i + "," + j);
        System.out.println("depth : " + depth + " max : " + max);

        int cnt = 1;

        if (hashmap.containsKey(i + "," + j)) {
            System.out.println("저장돼있는 " + hashmap.get(i + "," + j) + "가져옴");
            return hashmap.get(i + "," + j);
        }

        stack.push(new int[]{i, j});


        int[] cur = stack.pop();
        visited[cur[0]][cur[1]] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {
                if (!visited[nx][ny] && board[nx][ny] > board[i][j]) {
                    dfs(nx, ny, depth + 1);
                    cnt++;
                    visited[nx][ny] = false;
//                        System.out.println("cnt : " + cnt);
                }
            }
        }


        System.out.println("hashmap " + i + "," + j + "에 " + cnt + "저장");
        hashmap.put(i + "," + j, cnt);
        max = Math.max(max, cnt); // 최고로 멀리 갈 수 있는 거리
        return depth;
    }   // dfs
}
