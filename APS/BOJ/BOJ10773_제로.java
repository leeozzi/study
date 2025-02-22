package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10773_제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int next = sc.nextInt();
            if (next == 0) {
                stack.pop();
            } else {
                stack.push(next);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
