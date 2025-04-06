package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            weights[i] = Integer.parseInt(input[0]);
            values[i] = Integer.parseInt(input[1]);
        }

        // 무게를 하나씩 올려보면서 저장
        int[] dp = new int[k+1];

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }

        System.out.println(dp[k]);
    }
}