package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11403_경로찾기_메모리초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] res = new int[N][N];
        boolean[][] visited;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 입력 받음

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            visited = new boolean[N][N];
            queue.add(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 0; j < N; j++) {
                    if (map[cur][j] == 1 && !visited[cur][j]) {
                        res[i][j] = 1;
                        queue.add(j);
                        visited[cur][i] = true;
                    }
                }
            }

        }   // 행 for문

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
