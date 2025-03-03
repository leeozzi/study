package BOJ;

import java.util.Scanner;

public class BOJ31429_SUAPC2023Summer {
    public static void main(String[] args) {
        int[][] board = {
                {12, 1600},
                {11, 894},
                {11, 1327},
                {10, 1311},
                {9, 1004},
                {9, 1178},
                {9, 1357},
                {8, 837},
                {7, 1055},
                {6, 556},
                {6, 773}
        };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(board[n-1][0] + " " + board[n-1][1]);
    }
}
