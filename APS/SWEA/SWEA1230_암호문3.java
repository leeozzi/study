package SWEA;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA1230_암호문3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int N = sc.nextInt();    // 암호문 개수
            List<Integer> list = new LinkedList<>();    // 암호문 뭉치
            for (int i = 0; i < N; i++)
                list.add(sc.nextInt());// 암호문 뭉치 만들어줌
            int M = sc.nextInt();   // 명령어 개수
            for (int i = 0; i < M; i++) {
                String command = sc.next();
                if (command.equals("I")) {
                    int x = sc.nextInt();   // 앞에서부터 x번째 암호문 바로 다음에
                    int y = sc.nextInt();   // y개의 암호문을 삽입한다
                    for(int j = 0; j < y ; j++) {
                        int s = sc.nextInt();
                        list.add(x, s);
                        x++;
                    }
                } else if (command.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for(int j = 0 ; j < y ; j++) {
                        list.remove(x);
                    }
                } else if (command.equals("A")) {
                    int y = sc.nextInt();
                    for (int j =  0 ; j < y ; j ++) {
                        list.add(list.size()-1, sc.nextInt());
                    }
                }
            }

            System.out.print("#" + t + " ");
            for(int i= 0 ; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
