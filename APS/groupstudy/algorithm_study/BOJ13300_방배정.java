package groupstudy.algorithm_study;

import java.util.Scanner;

public class BOJ13300_방배정 {
    /**
     * 방 배정
     * <a href="https://www.acmicpc.net/problem/13300">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] gender = new int[n];
        int[] grade = new int[n];

        for (int i = 0; i < n; i++) {
            gender[i] = sc.nextInt();
            grade[i] = sc.nextInt();
        }

        // 성별 + 학년별 숫자 카운팅
        int[] male = {0, 0, 0, 0, 0, 0};
        int[] female = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < n; i++) {
            if (gender[i] == 1) {
                male[grade[i] - 1]++;
            } else {
                female[grade[i] - 1]++;
            }
        }

        // 방 개수 세기
        int roomCnt = 0;
        System.out.println(cnt(female, 0, k) + cnt(male, 0, k));


    }   // main

    public static int cnt(int[] arr, int roomCnt, int k) {
        for (int i = 0; i < 6; i++) {
            if (arr[i] > 0) {
                roomCnt += (int) (Math.ceil((double) arr[i] / (double) k));
            }
        }

        return roomCnt;
    }   //  방 개수 세기
}
