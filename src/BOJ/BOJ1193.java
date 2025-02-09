package BOJ;

import java.util.Scanner;

public class BOJ1193 {
    /**
     * 분수찾기
     * <a href="https://www.acmicpc.net/problem/1193">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int curX = 0;
        int curY = 0;
        int line = 1;

        for(int i = 1 ; i < X ; i ++) {
//            System.out.println("i = " + i);

            if(curX == 0 && line % 2 == 1) {
                curY++;
                line++;
//                System.out.println("조건1 - " + curX + " " + curY);
//                System.out.println("cnt : " + cnt);
            } else if (curY == 0 && line % 2 == 0) {
                curX++;
                line++;
//                System.out.println("조건2 - " + curX + " " + curY);
//                System.out.println("cnt : " + cnt);
            } else if(line % 2 == 1 ) {
                curX--;
                curY++;
//                System.out.println("조건3 - " + curX + " " + curY);
//                System.out.println("cnt : " + cnt);
            } else if (line % 2 == 0) {
                curX++;
                curY--;
//                System.out.println("조건4 - " + curX + " " + curY);
//                System.out.println("cnt : " + cnt);
            }
        }

        System.out.println((curX+1) + "/" + (curY+1));



    }
}
