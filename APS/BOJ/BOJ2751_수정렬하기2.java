package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2751_수정렬하기2 {
    /** 수 정렬하기 2
     * <a href="https://www.acmicpc.net/problem/2751">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] pluscnt = new int[1000001];
        int[] minuscnt = new int[1000001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num >= 0)
                pluscnt[num]++;
            else
                minuscnt[-num]++;
        }

        for (int i = minuscnt.length-1; i >= 1; i--) {
            if (minuscnt[i] != 0) {
                sb.append(-i + "\n");
            }
        }

        for (int i = 0; i < pluscnt.length; i++) {
            if (pluscnt[i] != 0) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }
}
