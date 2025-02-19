package SWEA;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA1225_암호생성기 {
    /**
     * 암호생성기 (Queue 안 쓰고 LinkedList로 풂)
     * <a href="https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            sc.nextInt();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                list.add(sc.nextInt());
            }

//            System.out.println("list : " + list);

            loop:
            while(true) {
                for (int i = 1; i <= 5; i++) {
                    list.add(list.get(0) - i);
                    list.remove(0);

                    if (list.getLast() <= 0) {
                        list.set(list.size()-1, 0);
                        break loop;
                    }
                }
            }


            StringBuilder sb = new StringBuilder();

            for(int e : list) {
                sb.append(e + " ");
            }

            System.out.println("#" + t + " " + sb);
        }
    }


}
