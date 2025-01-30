package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(reverse(a), reverse(b)));
    }

    private static int reverse(int n) {
        int a = n / 100;
        int b = (n % 100) / 10;
        int c = n % 10;
        int res = c * 100 + b * 10 + a;
        return res;
    }
}
