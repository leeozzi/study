package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622_다이얼 {
    /**
     * 다이얼
     * <a href="https://www.acmicpc.net/problem/5622">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'C') sum += 3;
            else if (c >= 'D' && c <= 'F') sum += 4;
            else if (c >= 'G' && c <= 'I') sum += 5;
            else if (c >= 'J' && c <= 'L') sum += 6;
            else if (c >= 'M' && c <= 'O') sum += 7;
            else if (c >= 'P' && c <= 'S') sum += 8;
            else if (c >= 'T' && c <= 'V') sum += 9;
            else if (c >= 'W' && c <= 'Z') sum += 10;
        }
        System.out.println(sum);
    }
}
