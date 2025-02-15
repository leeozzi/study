package BOJ;

import java.io.*;

public class BOJ2010_플러그 {
    /**
     * 플러그
     * https://www.acmicpc.net/problem/2010
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            cnt = cnt + Integer.parseInt(br.readLine()) - 1;
        }

        System.out.println(cnt);
    }
}
