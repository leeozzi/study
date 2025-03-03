package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751_수정렬하기2_2 {
    /** 수 정렬하기 2
     * <a href="https://www.acmicpc.net/problem/2751">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);

        for(int i = 0 ; i < N ; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.println(sb);
    }
}
