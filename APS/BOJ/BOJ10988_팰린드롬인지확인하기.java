package BOJ;

import java.util.Scanner;

public class BOJ10988_팰린드롬인지확인하기 {
    /**
     * 팰린드롬인지확인하기
     * <a href="https://www.acmicpc.net/problem/10988">...</a>
     */
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
