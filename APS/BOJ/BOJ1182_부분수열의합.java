package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부분 수열의 합
 * <a href="https://acmicpc.net/problem/1182">...</a>
 */

public class BOJ1182_부분수열의합 {

    static int N, S;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        getSum(0, 0, 0);

        System.out.println(cnt);
    }

    public static void getSum(int idx, int sum, int include) {

        if (idx == N) {    // 모든 원소를 확인했으면 리턴
            if (include != 0 && sum == S) {
                cnt++;
            }
            return;
        }

        getSum(idx + 1, sum, include);
        getSum(idx + 1, sum + arr[idx], include+1);

    }
}
