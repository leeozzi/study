package BOJ;

import java.io.*;

public class BOJ2810 {
    /**
     * 컵홀더
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String seats = br.readLine();
        int cnt = 0;
        int i = 0;

        while (i < n) {
            char c = seats.charAt(i);
            if (c == 'L') {
                cnt++;
                i += 2;
            } else {
                cnt++;
                i += 1;
            }
        }

        if (cnt + 1 > n) {
            System.out.println(n);
        } else {
            System.out.println(cnt + 1);
        }

    }
}
