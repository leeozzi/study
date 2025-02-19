package SWEA;

import java.util.Scanner;
public class SWEA1216_회문2 {

    static char[][] board;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();

            // board 만들기
            board = new char[100][100];


            for (int i = 0; i < 100; i++) {
                String line = sc.next();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            max = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    palindrome(i, j);
                }
            }

            System.out.println("#" + tc + " " + max);

        }

    }

    public static void palindrome(int i, int j) {
        // 홀수 길이의 회문일 때
        int len = 1;
        while (j - len >= 0 && j + len < board[0].length) {
            if (board[i][j - len] == board[i][j + len]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2 - 1, max);

        // 짝수 길이의 회문일 때
        len = 0;
        while (j - len >= 0 && j + len + 1 < board[0].length) {
            if (board[i][j - len] == board[i][j + 1 + len]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2, max);

        // 세로 방향 회문 검사
        // 홀수일 때
        len = 1;
        while (i - len >= 0 && i + len < board.length) {
            if (board[i - len][j] == board[i + len][j]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2 - 1, max);

        // 짝수일 때
        len = 0;
        while (i - len >= 0 && i + len + 1 < board.length) {
            if (board[i - len][j] == board[i + 1 + len][j]) {
                len++;
            } else {
                break;
            }
        }
        max = Math.max(len * 2, max);
    }

}
