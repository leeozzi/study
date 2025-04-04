package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N + 1][N + 1];
        int[][] sumMap = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
                temp += map[i][j];
                sumMap[i][j] = temp;
            }
        }
        // 입력 받음

        for (int m = 0; m < M; m++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);

            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int sum = 0;
            for (int i = 0; i <= (x2 - x1); i++) {
                sum += (sumMap[x1 + i][y2] - sumMap[x1 + i][y1 - 1]);
            }

            System.out.println(sum);
        }

    }
}
