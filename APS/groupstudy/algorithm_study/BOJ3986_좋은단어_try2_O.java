package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986_좋은단어_try2_O {
    /**
     * 좋은 단어
     * <a href="https://www.acmicpc.net/problem/3986">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < word.length(); j++) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals(word.charAt(j) + "")) {
                        stack.pop();
                    } else {
                        stack.add(word.charAt(j) +"");
                    }
                } else {
                    stack.add(word.charAt(j) + "");
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
