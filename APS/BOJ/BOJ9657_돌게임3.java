package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 게임 3
 * https://www.acmicpc.net/problem/9657
 */

public class BOJ9657_돌게임3 {
    public static void main(String[] args) throws IOException {
        // 돌은 1개, 3개, 4개 가져갈 수 있다
        // 마지막 돌을 가져가는 사람이 이긴다
        // 상근이 먼저 시작 (SK vs CY)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;  // 1
        dp[2] = 2;  // 1 1
        dp[3] = 1;  // 3
        dp[4] = 1;  // 1
        dp[5] = 3;

        for (int i = 6; i < dp.length; i++) {
            int num1 = 1 + dp[i - 1];
            int num2 = 1 + dp[i - 3];
            int num3 = 1 + dp[i - 4];

            // 승패에는 총 횟수가 홀수가 되는지 짝수가 되는지만 중요하므로 그냥 1, 2 넣어줌
            if(num1 % 2 == 1 || num2 % 2 == 1 || num3 % 2 == 1) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
        }

        if(dp[N] % 2 == 1) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }
    }
}
