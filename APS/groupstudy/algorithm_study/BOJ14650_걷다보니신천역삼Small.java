package groupstudy.algorithm_study;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/14650
 */

public class BOJ14650_걷다보니신천역삼Small {

    static int n, cnt;
    static int[] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        res = new int[n];

        perm(0);
        System.out.println(cnt);
    }

    private static void perm(int idx) {
        if(idx > 0 && res[0] == 0) return;

        if (idx == n) {
            String str = "";
            for (int i = 0; i < n; i++) {
                str += res[i];
            }
            int num = Integer.parseInt(str);

            if (num % 3 == 0) cnt++;
            return;
        }

        for (int i = 0; i <= 2; i++) {
            res[idx] = i;
            perm(idx + 1);
        }

    }
}
