package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25918_북극곰은괄호를찢어_시간초과 {
    /**
     * 북극곰은 괄호를 찢어
     * <a href="https://acmicpc.net/problem/25918">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int days = 0;

        while(S.contains("()") || S.contains(")(")) {
            days++;
            S = S.replace("()", "");
            S = S.replace(")(", "");
        }

        if(!S.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(days);
    }
}
