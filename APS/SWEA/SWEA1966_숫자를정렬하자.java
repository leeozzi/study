package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1966_숫자를정렬하자 {
    /**
     * 숫자를 정렬하자
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PrmyKAWEDFAUq">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0 ;i < N ;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            System.out.printf("#%d ", t);
            for(int i =0 ; i < arr.length ;i ++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}
