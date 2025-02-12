package BOJ;

import java.util.Scanner;

public class BOJ2563_색종이 {
    /**
     * 색종이
     * <a href="https://www.acmicpc.net/problem/2563">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[100][100];
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int startrow = sc.nextInt();
            int startcol = sc.nextInt();

            for(int r = startrow ; r < startrow + 10 ; r++) {
                for (int c = startcol ; c < startcol + 10 ; c++) {
                    if(board[r][c] == 0) {
                        board[r][c] = 1;
                        sum++;
                    }
                }
            }

        }

        System.out.println(sum);

    }
}
