package BOJ;

import java.io.*;

public class BOJ11720_숫자의합 {
    /**
     * 숫자의 합
     * <a href="https://www.acmicpc.net/problem/11720">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String line = br.readLine();
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        System.out.println(sum);


    }
}
