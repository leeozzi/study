package BOJ;

import java.util.Scanner;

public class BOJ5596_시험점수 {
    /**
     * 시험 점수
     * <a href="https://www.acmicpc.net/problem/5596">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 0;
        for(int i= 0 ; i < 4; i ++) {
            min += sc.nextInt();
        }
        int man = 0;
        for(int i= 0 ;i < 4 ; i++) {
            man += sc.nextInt();
        }

        System.out.println(Math.max(min, man));

    }
}
