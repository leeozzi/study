package groupstudy.algorithm_lunchStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2842_외계인의기타연주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        Stack<Integer>[] stacks = new Stack[6];
        for (int i = 0; i < 6; i++) {
            stacks[i] = new Stack<>();
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int line = Integer.parseInt(input[0]);
            int pret = Integer.parseInt(input[1]);

            if (stacks[line - 1].isEmpty()) {
                stacks[line - 1].push(pret);
                cnt++;
            } else {
                if (stacks[line - 1].peek() == pret) continue;

                if (stacks[line - 1].peek() < pret) {
                    stacks[line - 1].push(pret);
                    cnt++;
                } else if (stacks[line - 1].peek() > pret) {
                    while (!stacks[line - 1].isEmpty() && stacks[line - 1].peek() > pret) {
                        stacks[line - 1].pop();
                        cnt++;
                    }
                }
            }

            if (stacks[line - 1].isEmpty() || pret > stacks[line - 1].peek()) {
                stacks[line - 1].push(pret);
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
