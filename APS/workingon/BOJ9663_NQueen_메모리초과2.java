package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * NQueen
 * <a href="https://acmicpc.net/problem/9663">...</a>
 */

/*
혹시 onoff 함수로 빼준 게 스택 메모리에 문제가 됐나 싶어서 로직만 떼왔는데 여전히 메모리 초과
 */

public class BOJ9663_NQueen_메모리초과2 {
    static int[][] board;
    static int cnt = 0;
    static int N, queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        queen = N;

        placeQueen(0, queen);


        System.out.println(cnt);
    }

    private static void placeQueen(int x, int queen) {   // x열에서 둘 곳 찾기
        if (x == N) {
            if (queen == 0) {
                cnt++;
            }
            return;
        }

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < N; i++) {
            if (board[x][i] == 0) {  // 빈 자리면 두고
                queen--;

                for (int d = 0; d < 8; d++) {
                    for (int j = 1; j < N; j++) {
                        int nx = x + dx[d] * j;
                        int ny = i + dy[d] * j;

                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            board[nx][ny] += 1;
                        }
                    }
                }

                placeQueen(x + 1, queen);

                for (int d = 0; d < 8; d++) {
                    for (int j = 1; j < N; j++) {
                        int nx = x + dx[d] * j;
                        int ny = i + dy[d] * j;

                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            board[nx][ny] -= 1;
                        }
                    }
                }
                queen++;
            }
        }

    }

}
