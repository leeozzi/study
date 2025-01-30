package BOJ;

import java.util.Scanner;

public class BOJ5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stds = new int[31];

        for (int i = 0; i < 28; i++) {
            stds[sc.nextInt()] = 1;
        }

        for (int i = 1; i < 31; i++) {
            if (stds[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
