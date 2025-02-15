package workingon;

import java.util.Scanner;

public class BOJ11726_2xN타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        System.out.println(dp[n]%10007);
    }
}
