package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2566_최댓값 {
    /**
     * 최댓값
     * <a href="https://www.acmicpc.net/problem/2566">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = 0;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num >= maxNum) {
                    maxNum = num;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println(maxNum);
        System.out.println((maxRow + 1) + " " + (maxCol + 1));

    }
}
