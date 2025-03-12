package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] apt = new int[14][14];



        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                System.out.print(apt[i][j] + " ");
            }
            System.out.println();
        }

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());


        }
    }
}
