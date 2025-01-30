package BOJ;

import java.util.Scanner;

public class BOJ10809 {
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
