package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 개수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        // 트리 배열 만들어주기
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, arr[i]);
        }

        // 이분탐색
        int left = 0;
        int right = maxHeight;
        int res = 0;

//        Arrays.sort(arr); // 필요없음...어차피 첨부터 다 돌아줄 건데

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid)
                    sum += (arr[i] - mid);
            }

            if (sum < M)
                right = mid - 1;

            else if (sum >= M) {
                res = mid;
                left = mid + 1;
            }
        }

        System.out.println(res);

    }
}