package groupstudy.algorithm_lunchStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ25918_북극곰은괄호를찢어 {
    /**
     * 북극곰은 괄호를 찢어
     * <a href="https://acmicpc.net/problem/25918">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < N; i++) {
            char cur = str.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                if ((stack.peek() == '(' && cur == ')') || (stack.peek() == ')' && cur == '(')) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }

            res = Math.max(res, stack.size());
        }

        if (stack.isEmpty())
            System.out.println(res);
        else
            System.out.println(-1);
    }
}
