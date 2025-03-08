package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Character> list = new ArrayList<>();
        list.add('(');
        list.add(')');
        list.add('[');
        list.add(']');
        while (!str.equals(".")) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (!list.contains(cur)) continue;
                if (stack.isEmpty())
                    stack.push(cur);
                else {
                    if ((stack.peek() == '(' && cur == ')') ||
                            (stack.peek() == '[' && cur == ']')) {
                        stack.pop();
                    } else {
                        stack.push(cur);
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            str = br.readLine();
        }
    }
}
