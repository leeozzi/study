package Study.algorithm_study;

import java.io.IOException;
import java.util.Scanner;

public class BOJ2448_ON {

    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static StringBuilder sb3 = new StringBuilder();


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        stars(N);

    }

    public static void stars(int n) throws IOException {
        String pattern = "";

        String line1 = "";
        String line2 = "";
        String line3 = "";

        if (n == 3) {
            pattern = "*";
            line1 = "  *   ";
            line2 = " *  *  ";
            line3 = "***** ";
        }

        if (n == 6) {
            sb1.append(" ".repeat(3 * (n / 3 - 1)) + line1 + " ".repeat(3 * (n / 3 - 1)));
            sb2.append(" ".repeat(3 * (n / 3 - 1)) + line2 + " ".repeat(3 * (n / 3 - 1)));
            sb3.append(" ".repeat(3 * (n / 3 - 1)) + line3 + " ".repeat(3 * (n / 3 - 1)));
        }





//        if (num < 3) {
//            return;
//        }
//
//
//        int len = num * 2 - 1;
//        int blank = (len - 1) / 2;
//
//        line1 = " ".repeat(blank) + "*" + " ".repeat(blank);
//        line2 = " ".repeat(blank - 1) + "*" + " ".repeat(len - (2 * (blank - 1) + 2)) + "*" + " ".repeat(blank - 1);
//        line3 = " ".repeat(blank - 2) + "*".repeat(5) + " ".repeat(blank - 2);
//
//        for (int i = 0; i < 2; i++) {
//            sb1.append(line1);
//            sb2.append(line2);
//            sb3.append(line3);
//        }
//
//        System.out.println(sb1);
//        System.out.println(sb2);
//        System.out.println(sb3);

    }


}
