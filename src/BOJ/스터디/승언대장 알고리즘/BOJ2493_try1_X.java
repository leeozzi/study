package BOJ;

import java.util.Scanner;

public class BOJ2493_try1_X {
    /**
     * 탑
     * 메모리 초과
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] towers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            towers[i] = sc.nextInt();
        }
        int[] receive = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j > 0; j--) {
                if (towers[j] >= towers[i]) {
                    receive[i] = j;
                    break;
                } else {
                    receive[i] = 0;
                }
            }
        }

        for (int i = 1; i < receive.length; i++) {
            System.out.print(receive[i] + " ");
        }
    }
}
