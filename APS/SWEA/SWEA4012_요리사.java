package SWEA;

import java.util.*;

public class SWEA4012_요리사 {
    /**
     * 요리사
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH">...</a>
     */

    static int[][] board;
    static boolean[] vis;
    static int N;   // 식재료 개수
    static int min;
    static List<Integer> combi1;
    static List<Integer> combi2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            board = new int[N][N];
            vis = new boolean[N];
            combi1 = new ArrayList<>();
            combi2 = new ArrayList<>();
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }   /// 여기까지 입력받기

            for (int i = 0; i < N / 2; i++) {
                combi1.add(0);
            }

            combi(0, 0);
            System.out.printf("#%d %d\n", t, min);
        }   // testCase 끝
    }   // main 끝

    // 일단 식재료 뭐뭐 고를지부터 정하자
    public static void combi(int sidx, int idx) {
        if (sidx == N / 2) {
            // combi2 만들어줘
            combi2.clear();
            for(int i = 0 ; i < N ; i++) {
                combi2.add(i);
            }
            combi2.removeAll(combi1);

//            System.out.println(combi1);
//            System.out.println(combi2);

            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0 ; i < N/2 ; i++) {
                for(int j = 0 ; j < N/2; j++) {
                    if(i != j) {
                        sum1 += board[combi1.get(i)][combi1.get(j)];
                        sum2 += board[combi2.get(i)][combi2.get(j)];
                    }
                }
            }

//            System.out.println("sum1 : " + sum1 + " sum2 : " + sum2);
            int diff = Math.abs(sum1 - sum2);
//            System.out.println("diff : " + diff);
            min = Math.min(min, diff);
            return;
        }
        if (idx == N) return;

        combi1.set(sidx, idx);
        combi(sidx + 1, idx + 1);
        combi(sidx, idx + 1);
    }
}   // class 끝
