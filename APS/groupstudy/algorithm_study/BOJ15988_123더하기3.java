package groupstudy.algorithm_study;

import java.util.Scanner;

public class BOJ15988_123더하기3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] dp = new long[1000001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }
    }
}
