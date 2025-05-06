package groupstudy.algorithm_study;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/2493
 */
public class BOJ2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n];
        int[] res = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(input[i]);
        }
        // 입력

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && towers[stack.peek()] >= towers[i]) {
                res[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
    }
}
