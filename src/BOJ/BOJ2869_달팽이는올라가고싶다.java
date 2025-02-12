package BOJ;

import java.util.Scanner;

public class BOJ2869_달팽이는올라가고싶다 {
    /**
     * 달팽이는 올라가고 싶다
     * <a href="https://www.acmicpc.net/problem/2869">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int day = 0 ;
        int aim = v-a;
        if(aim % (a-b) == 0) {
            day = aim / (a-b) + 1;
        } else {
            day = aim / (a-b) + 2;
        }

        System.out.println(day);


        // 아래 답안은 시간 초과 뜸
//        int cur = 0 ;
//        int day = 0 ;
//        while(cur < v) {
//            cur += a;
//            if(cur < v) {
//                cur-= b;
//            }
//            day ++;
//
//        }
//        System.out.println(day);


    }
}
