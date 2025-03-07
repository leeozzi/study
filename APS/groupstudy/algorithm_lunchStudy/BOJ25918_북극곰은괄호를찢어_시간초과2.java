package groupstudy.algorithm_lunchStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ25918_북극곰은괄호를찢어_시간초과2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int days = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();

        while(flag) {
            days++;
            flag = false;
            for (int i = 0; i < S.length(); i++) {
                char cur = S.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(cur);
                } else {
                    char before = stack.peek();

                    if ((before == '(' && cur == ')') || (before == ')' && cur == '(')) {
                        stack.pop();
                        stack.push('O');
//                        System.out.println(before + "랑 " + cur + "랑 만나서 사라짐");
                        flag = true;
                    } else {
                        stack.push(cur);
//                        System.out.println(stack);
                    }
                }
            }   // 이거 돌고 나오면 이번 회차에 짝 맞는 애들 O로 바꿔서 stack 넣어줬어

            sb = new StringBuilder();
            while(!stack.isEmpty()) {
                char cur = stack.pop();
                if(cur != 'O'){
                    sb.append(cur);
                }
            }

            S = sb.toString();

            if(S.isEmpty())
                break;
        }

        if(stack.isEmpty())
            System.out.println(days);
        else
            System.out.println(-1);

    }   // main
}   // class

