package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663_NQueen_메모리초과 {
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

        for (int i = 0; i < N; i++) {
            if (board[x][i] == 0) {  // 빈 자리면 두고
                queen--;
                onoff(x, i, 1); // 공격할 수 있는 범위 체크
                placeQueen(x + 1, queen);
                queen++;
                onoff(x, i, -1);
            }
        }

    }

    private static void onoff(int x, int y, int status) {
        // status가 1이면 공격하는 거고, 백트래킹할 때는 -1로 빼주면 됨
        // 좌표 하나를 기점으로 공격 가능한 범위 쭉 공격해줌
        // board에는 공격 받을 수 있는 경우의 수들이 누적돼있을 것
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < N; i++) {
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d] * i;
                int ny = y + dy[d] * i;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    board[nx][ny] += status;
                }
            }
        }

        System.out.println("=========================");
        System.out.println(x + ", " + y +"에서 " + status);
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8);
        }
    }
}
