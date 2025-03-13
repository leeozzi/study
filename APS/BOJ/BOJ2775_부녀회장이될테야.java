package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775_부녀회장이될테야 {
    /**
     * 부녀회장이 될 테야
     * <a href="https://www.acmicpc.net/problem/2775">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] apt = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apt[0][i] = i + 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += apt[i - 1][k];
                }
                apt[i][j] = sum;
            }
        }


        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            System.out.println(apt[K][N-1]);

        }
    }
}
