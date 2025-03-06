package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20922_겹치는건싫어 {
    /**
     * 겹치는 건 싫어
     * <a href="https://www.acmicpc.net/problem/20922">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 길이가 N인 수열. 10만 이하
        int K = Integer.parseInt(input[1]); // K개 이하로 포함. 100개 이하
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        } // 수열 담아줌

        int[] cnt = new int[1000001];

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < N) {
//            System.out.println("현재 왼쪽 위치 : " + left + " 현재 오른쪽 위치 : " + right);
            cnt[arr[right]]++;  // 현재 숫자 카운트 추가
            // 만약 현재 숫자가 K를 초과하면
            if (cnt[arr[right]] > K) {
                cnt[arr[left]]--;
                left++;
            }
            right++;
        }

        System.out.println(maxLen);
    }

}
