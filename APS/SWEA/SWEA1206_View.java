package SWEA;

import java.util.Scanner;

public class SWEA1206_View {
    /**
     * View
     * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 10; t++) {
            int N = sc.nextInt();
            int[] buildings = new int[N];

            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }

            int cnt = 0;

            for (int i = 2 ; i < N-2 ; i++) {
                int cur = buildings[i];
                if(buildings[i-2] < cur && buildings[i-1] < cur
                        && buildings[i+1] < cur && buildings[i+2] < cur) {
                    int max1 = Math.max(buildings[i-2], buildings[i-1]);
                    int max2 = Math.max(buildings[i+2], buildings[i+1]);
                    int max = Math.max(max1, max2);
                    cnt += cur-max;
                }
            }

            System.out.println(cnt);


        }


    }

}
