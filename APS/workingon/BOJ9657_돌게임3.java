package workingon;

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

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 2;


    }
}
