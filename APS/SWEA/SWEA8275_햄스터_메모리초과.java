package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA8275_햄스터_메모리초과 {

    static int N, X, M;
    static int[] res, ans;
    static int[][] notes;
    static int max = 0, totalsum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]); // 케이지 개수
            X = Integer.parseInt(input[1]); // 한 케이지 당 최대 햄스터 수
            M = Integer.parseInt(input[2]); // 기록 개수

            res = new int[N];

            notes = new int[M][3];
            for (int m = 0; m < M; m++) {
                input = br.readLine().split(" ");
                for (int i = 0; i < 3; i++) {
                    notes[m][i] = Integer.parseInt(input[i]);
                }
            }
            // INPUT 끝

            comb(0, N, X);

            System.out.printf("#%d ", t);
            if (ans != null) {
                for (int i = 0; i < ans.length; i++) {
                    sb.append(ans[i]).append(" ");
                }
                sb.append("\n");
            } else {
                sb.append(-1+"\n");
            }
            max = 0;
            ans = null;
        }   // 테케 끝
    }   // 메인 끝

    public static void comb(int idx, int N, int X) {
        if (idx == N) {
            for (int i = 0; i < M; i++) {
                int l = notes[i][0] - 1;
                int r = notes[i][1] - 1;
                int s = notes[i][2];

                int sum = 0;
                for (int j = l; j <= r; j++) {
                    sum += res[j];
                }

                if (sum != s) {
                    return;
                }
            }

            totalsum = 0;
            for (int i = 0; i < res.length; i++) {
                totalsum += res[i];
            }
            if (totalsum > max) {
                ans = Arrays.copyOf(res, res.length);
                max = totalsum;
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            res[idx] = i;
            comb(idx + 1, N, X);
        }
    }
}
