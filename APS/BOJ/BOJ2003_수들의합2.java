package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // N개의 수열
        int M = Integer.parseInt(input[1]); // 부분합이 M이 되는 경우의 수 구하기

        int[] arr = new int[N];
        int[] sum = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if (i == 0) sum[i] = arr[i];
            else sum[i] = sum[i - 1] + arr[i];
        }

        int ans = 0;
        int leftidx = 0;
        int left = 0;
        while(leftidx < arr.length) {
            for (int i = leftidx; i < N; i++) {
                if (sum[i] - left == M) {
                    ans++;
                    break;
                }
                else if (sum[i] - left > M) {
                    break;
                }
            }
            left = sum[leftidx];
            leftidx++;
        }
        System.out.println(ans);
    }
}
