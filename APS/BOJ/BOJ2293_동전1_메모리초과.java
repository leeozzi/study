package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2293_동전1_메모리초과 {
    static int n, k;
    static int[] coins, dp;
    static List<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        coins = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        res = new ArrayList<>();

        for(int i = 0 ; i <= k ; i++) {
            dp[i] = comb(i, 0, new HashSet<>());
        }

        System.out.println(dp[k]);
    }

    // 주어진 동전들로 k를 만드는 조합의 수
    private static int comb(int target, int sum, Set<String> set) {

        if (sum > target) return set.size();

        if (sum == target) {
            Collections.sort(res);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
            }
            String result = sb.toString();
            if (!set.contains(result) && !result.equals("")) {
                set.add(result);
            }

            return set.size();
        }

        for (int i = 0; i < n; i++) {
            sum += coins[i];
            res.add(coins[i]);
            comb(target, sum, set);
            res.remove(Integer.valueOf(coins[i]));
            sum -= coins[i];
        }

        return set.size();
    }


}
