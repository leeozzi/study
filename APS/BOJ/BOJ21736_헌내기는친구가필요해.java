package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ21736_헌내기는친구가필요해 {

    static char[][] map;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        map = new char[N][M];
        int[] doyeon = new int[2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }
        // 입력 끝

        // bfs 로 가자
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(doyeon);
        visited[doyeon[0]][doyeon[1]] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + cur[0];
                int ny = dy[d] + cur[1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X') continue;
                if(!visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    if(map[nx][ny]=='P') cnt++;
                }
            }
        }

        if(cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }
}
