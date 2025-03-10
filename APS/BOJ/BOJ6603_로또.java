package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6603_로또 {
    /**
     * 로또
     * <a href="https://www.acmicpc.net/problem/6603">...</a>
     */

    static int[] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!input.equals("0")) {
            String[] temp = input.split(" ");
            arr = new int[temp.length - 1];
            res = new int[6];
            int K = Integer.parseInt(temp[0]);
            for (int i = 1; i < temp.length; i++) {
                arr[i - 1] = Integer.parseInt(temp[i]);
            }   // 입력 받음

            comb(0, 0);

            System.out.println();
            input = br.readLine();
        }
    }

    private static void comb(int cur, int idx) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = cur; i < arr.length; i++) {
            res[idx] = arr[i];
            comb(i + 1, idx + 1);
        }
    }
}
