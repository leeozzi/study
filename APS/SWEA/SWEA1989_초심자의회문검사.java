package SWEA;

import java.util.Scanner;

public class SWEA1989_초심자의회문검사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        testcase:
        for(int t = 1; t <= T ; t++) {
            String word = sc.next();
            for(int i = 0 ; i < word.length()/2 ; i++) {
                if(word.charAt(i) != word.charAt(word.length()-1-i)) {
                    System.out.println("#" + t + " " + 0);
                    continue testcase;
                }
            }
            System.out.println("#" + t + " " + 1);
        }
    }
}
