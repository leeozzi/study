package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        int[] cnts = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            cnts[arr[i]]++;
        }
        // 입력 받기 완료

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(cnts));


        
        int left = 0;
        int right = arr.length - 1;


    }

}
