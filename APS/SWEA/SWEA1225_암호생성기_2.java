package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225_암호생성기_2 {
    /**
     * 암호생성기_2 (Queue 써서 풂)
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            sc.nextInt();

            Queue<Integer> queue = new LinkedList<>();

            // 기존 숫자들 queue에 넣어주기
            for (int i = 0; i < 8; i++)
                queue.add(sc.nextInt());

            // cycle
            int i = 0;
            while (i++ <= 5) {
                int next = Math.max(queue.poll() - i, 0);
                queue.add(next);
                if(next == 0)
                    break;

                if(i == 5)
                    i = 0;

            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " ");
            while(!queue.isEmpty()) {
                sb.append(queue.poll() + " ");
            }
            System.out.println(sb);

        }
    }
}
