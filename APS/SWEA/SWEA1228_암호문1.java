package SWEA;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA1228_암호문1 {
    /**
     * 암호문1
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();   // 원본 암호문 길이
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }   // 원본 암호문
            int n = sc.nextInt();   // 명령어 개수
            for(int i = 0 ; i < n ; i++) {
                String command = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for(int j = 0 ; j < y ; j++) {
                    list.add(x, sc.nextInt());
                    x++;
                }
            }

            System.out.printf("#%d ", t);
            for(int i = 0 ;i < 10 ; i ++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

        }

    }
}
