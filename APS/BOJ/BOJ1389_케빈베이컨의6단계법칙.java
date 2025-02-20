package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1389_케빈베이컨의6단계법칙 {

    static int[][] board;
    static int[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        board = new int[N + 1][N + 1];
        vis = new int[N + 1];

        // 연결관계 표로 만들어주기
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            board[a][b] = 1;
            board[b][a] = 1;
        }

    }

    public static void dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 시작점 일단 큐에 넣어주고
        vis[start] = 1; // 시작점 방문 체크해줘

        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 일단 시작점 빼주고
            for (int i = 1; i < board.length; i++) {    // 연결된 애들 큐에 쭉 넣어줄 거야
                if (vis[i] != 1 && board[start][i] == 1) {   // 아직 방문한 적 없고 시작점이랑 연결된 애면
                    queue.offer(i); // 큐에 넣어주고
                    vis[i] = 1; // 방문 체크
                }
            }
        }


    }

}
