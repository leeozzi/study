package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int i = 0 ; i < str.length() ; i++ ) {
                char cur = str.charAt(i);
                if(stack.isEmpty()) {
                    stack.push(cur);
                }

                else {
                    if(stack.peek() == '(' && cur == ')') {
                        stack.pop();
                    } else {
                        stack.push(cur);
                    }
                }
            }

            if(!stack.isEmpty()) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
