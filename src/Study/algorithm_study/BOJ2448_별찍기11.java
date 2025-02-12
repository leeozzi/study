package Study.algorithm_study;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ2448_별찍기11 {
    /**
     * 별 찍기 - 11
     * https://www.acmicpc.net/problem/2448
     */

    static Stack<String> stack = new Stack<>();


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        stars("  *   ", " * *  ", "***** ", 24);

    }

    public static void stars(String line1, String line2, String line3, int n) throws IOException {
        line1 = "   " + line1.repeat(n*2/line1.length()) + "   ";
        line2 = "   " + line2.repeat(n*2/line2.length()) + "   ";
        line3 = "   " + line3.repeat(n*2/line3.length()) + "   ";
        
        stars(line1, line2, line3, n/2);





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
