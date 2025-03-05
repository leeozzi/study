package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20922_겹치는건싫어 {
    /**
     * 겹치는 건 싫어
     * <a href="https://www.acmicpc.net/problem/20922">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            cnt[arr[i]]++;
        }
        // 입력 받기 완료

        int right = arr.length-1;
        int left = 0;
        int max = 0;

        while(left <= right) {
            for(int i = left ; i <= right ; i++) {

            }
        }
    }
}
