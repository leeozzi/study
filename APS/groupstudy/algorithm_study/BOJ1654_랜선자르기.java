package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        /* 입력 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선의 개수
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            String line = br.readLine();
            arr[i] = Integer.parseInt(line);
            max = Math.max(arr[i], max);
        }

        /* 이분 탐색 해줄 거야 */
        long left = 0;
        long right = max;
        long res = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
//            System.out.println("left : " + left + " right : " + right + " mid : " + mid);

            // 자른 개수 봐야지
            int cut = 0;
            for (int i = 0; i < K; i++) {
                if(mid == 0)
                    mid = 1;
                cut += (arr[i] / mid);
            }

            if (cut < N) {
                right = mid - 1;
            }

            if(cut >= N) {
                left = mid + 1;
                res = mid;
            }

        }

        System.out.println(res);


    }
}