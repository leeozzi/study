package BOJ;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BOJ2161_카드1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= N ; i++) {
            deque.add(i);
        }

        while(deque.size() > 1) {
            sb.append(deque.pop()).append(" ");
            int top = deque.pop();
            deque.addLast(top);
        }
        sb.append(deque.pop());
        System.out.println(sb);
    }
}
