package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16401_과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 조카의 수    최대 백만
        int N = Integer.parseInt(input[1]); // 과자의 수    최대 백만

        int[] arr = new int[N]; // 과자 길이    최대 10억... 매개변수 탐색?
        input = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            max = Math.max(max, arr[i]);
        }

        // 모든 조카에게 같은 길이의 막대과자를 나눠줄 수 없는 경우가 뭐가 있지
        // 아 막대과자 길이의 합이 조카의 수보다 작은 경우

        // 일단 max를 반으로 자른 길이로는 몇 명한테 줄 수 있는지 보자.
        // mid 인덱스 0 + arr.length / 2

        // max 보다 긴 애들이 몇 갠지 봐야 해
        // 카운팅은 음... 막대기 길이 arr[i] / 자른 길이 arr[mid] 해서 더해줘야 해.
        // 카운팅이 너무 많아. 그러면 mid = mid + arr.length - 1 / 2 해서 또 배열 끝까지 탐색 해
        // 너무 작으면 mid = (mid + arr[0]) / 2 해서 mid부터 끝까지 탐색해줄게

//        int right = max;
//        int left = 0;
//        int midlen = max / 2;
//        int res = 0;
//
//        while (left <= right) {
//            int cnt = 0;
//            midlen = (right + left) / 2;
//            System.out.println("===============");
//            System.out.println("현재 자르려는 길이 : " + midlen);
//
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] >= midlen) {
//                    cnt += arr[i] / midlen;   // midlen으로 잘랐을 때 나눠줄 수 있는 사람 수
//                }
//            }
//            System.out.println("cnt : " + cnt);
//
//            if (cnt < M) {  // 너무 적게 나눠줘. 좀 더 짧게 잘라서 많이 줘봐
//                right = midlen - 1;
//                System.out.println("너무 적게 나눠줬어. 기준 좀 더 왼쪽으로 " + right);
//            } else {    // 너무 많이 나눠줘. 좀 더 길게 잘라서 적게 줘봐
//                left = midlen;
//                System.out.println("너무 많이 나눠줬어. 기준 좀 더 오른쪽으로 " + left);
//            }
//        }
//
//        System.out.println(midlen);


        int left = 1;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;    // 수학적으로 (left + right) / 2 와 동일한 결과
            int count = 0;

            for (int length : arr) {
                count += length / mid;
            }

            if (count >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
