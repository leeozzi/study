package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA5432_쇠막대기자르기 {
    /**
     * 쇠막대기 자르기
     * IM 대비 문제
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String str = sc.next();
            String[] arr = str.split("");
            Stack<String> stack = new Stack<>();
            int floor = 0;
            int sum = 0;

            for (String s : arr) {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {
                    if (s.equals(")")) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            stack.add("*");
                        } else {
                            stack.add(s);
                        }
                    } else {
                        stack.add(s);
                    }
                }
            }

//            System.out.println(stack);

            while (!stack.isEmpty()) {
                String s = stack.pop();
                if(s.equals(")")) {
                    floor ++;
//                    System.out.println(") 만났고 현재 층수 " + floor);
                } else if (s.equals("*")) {
                    sum += floor;
//                    System.out.println("* 만났고 현재 층수 " + floor + " 현재 sum " + sum);
                } else if (s.equals("(")) {
                    sum++;
                    floor --;
//                    System.out.println("( 만났고 현재 층수 " + floor + " 현재 sum " + sum);
                }

            }

            System.out.println("#" + t + " " + sum);
        }
    }
}
