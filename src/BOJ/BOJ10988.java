package BOJ;

import java.util.Scanner;

public class BOJ10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w = sc.next();
        int flag = 1;

        for(int i =0 ; i < w.length();i++) {
            if(w.charAt(i) != w.charAt(w.length()-1-i)) {
                flag = 0;
            }
        }
        System.out.println(flag);
    }
}
