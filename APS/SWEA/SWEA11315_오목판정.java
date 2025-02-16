package SWEA;

import java.util.Scanner;

public class SWEA11315_오목판정 {
    /**
     * 오목판정
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ">...</a>
     */

    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            // 판 만들기
            int N = sc.nextInt();
            board = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            // o 찾기
            if (search()) {
                System.out.println("#" + t + " YES");
            } else {
                System.out.println("#" + t + " NO");
            }

        }
    }

    private static boolean search() {
        int[] dx = {0, 1, 1, -1};
        int[] dy = {1, 0, 1, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'o') {
                    for (int d = 0; d < 4; d++) {
                        int cnt = 1;
                        for (int n = 1; n < 5; n++) {
                            int nx = i + dx[d] * n;
                            int ny = j + dy[d] * n;

                            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {
                                if (board[nx][ny] == 'o') {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (cnt == 5) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
