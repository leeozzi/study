package workingon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA4012_요리사 {
    /**
     * 요리사
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH">...</a>
     */

    static int[][] board;
    static boolean[] vis;
    static int[] combi1;
    static int[] combi2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            board = new int[N][N];
            vis = new boolean[N];
            combi1 = new int[N/2];
            combi2 = new int[N/2];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }   /// 여기까지 입력받기

            int min = Integer.MAX_VALUE;
            min = Math.min(combi(0, N / 2, 0), min);
            System.out.println("combi1 : " + Arrays.toString(combi1));
            System.out.println("combi2 : " + Arrays.toString(combi2));
            System.out.println(min);
        }   // testCase 끝
    }   // main 끝

    public static int combi(int start, int n, int depth) {
        if (depth == n) {
            int sum1 = 0;
            int sum2 = 0;

            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n; j++) {
                    sum1 += board[combi1[i]][combi1[j]];
                    sum1 += board[combi1[j]][combi1[i]];

                    sum2 += board[combi2[i]][combi2[j]];
                    sum2 += board[combi2[j]][combi2[i]];
                }
            }

            System.out.println("sum1 : " + sum1 + " sum2 : " + sum2);
            return Math.abs(sum1-sum2);
        }

        for(int i = 0 ; i < board.length ; i++) {
            if (!vis[i]) {
                vis[i] = true;
                combi(i, n, depth + 1);
            } else {
                combi2[depth] = i;
            }
        }

        return depth;
    }
}   // class 끝
