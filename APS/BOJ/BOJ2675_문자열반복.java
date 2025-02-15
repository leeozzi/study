package BOJ;

import java.util.Scanner;

public class BOJ2675_문자열반복 {
    /**
     * 문자열 반복
     * <a href="https://www.acmicpc.net/problem/2675">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int repeat = sc.nextInt();
            String S = sc.next();
            for (int i = 0; i < S.length(); i++) {
                String letter = ""+S.charAt(i);
                System.out.print(letter.repeat(repeat));
            }
            System.out.println();
        }
    }
}
