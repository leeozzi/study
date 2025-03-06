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

        // i )
        // 왼쪽이 K개보다 많으면
        // cnts[arr[left]]-- 해주고
        // left++ 해서 옮기고
        // 옮긴 칸에서 또 봐. 본 숫자가 K개 이하일 때까지 옮겨.

        // 왼쪽 멈추고 나면 오른쪽 봐
        
        // 오른쪽이 K개보다 많으면
        // cnts[arr[left]]-- 해주고
        // right-- 해서 옮기고
        // 옮긴 칸에서 또 봐. cnt가 K개 이하인 애 나올 때까지 옮겨.

        // ii )
        // 그러다가 둘 다 멈추면, 거기서 한 번 arr[left -> right] 탐색
        // cnts[arr[i]] > K 인 애 발견하면
        // right - i 랑 left - i 랑 비교해서 더 작은 쪽 포인터를 걔한테까지 옮겨줄건데
        // 지나가는 애들 cnt 줄여주면서 가야 함

        // 도착하면 또 i부터 반복
        // ii 에서 cnts[arr[i]] > K 인 애가 없으면 right - left 해서 개수 구해줘
        
        int left = 0;
        int right = arr.length - 1;


    }

}
