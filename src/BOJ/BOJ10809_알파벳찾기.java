package BOJ;

import java.util.Scanner;

public class BOJ10809_알파벳찾기 {
    /**
     * 알파벳 찾기
     * <a href="https://www.acmicpc.net/problem/10809">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String line = sc.nextLine();
        for (int i = 0; i < alphabet.length(); i++) {
            char ch = alphabet.charAt(i);
            if (line.indexOf(ch) != -1) {
                System.out.print(line.indexOf(ch) + " ");
            } else
                System.out.print(line.indexOf(ch) + " ");
        }

    }
}
