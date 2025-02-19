package SWEA;

import java.util.Scanner;

public class SWEA1984_중간평균값구하기 {
    /**
     * 중간 평균값 구하기
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[10];

        for (int t = 1; t <= T; t++) {
            int max = 0;
            int min = 10000;

            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            double sum = 0;

            for (int i = 0; i < 10; i++) {
                if(arr[i] != max && arr[i] != min) {
                    sum += arr[i];
                }
            }

            System.out.println("#" + t + " " + Math.round(sum/8));

        }
    }
}
