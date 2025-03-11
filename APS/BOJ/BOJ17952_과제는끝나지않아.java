package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17952_과제는끝나지않아 {
    public static void main(String[] args) throws IOException {

        class HW {
            int score;
            int timeCost;

            public HW(int score, int timeCost) {
                this.score = score;
                this.timeCost = timeCost;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<HW> stack = new Stack<>();
        int sum = 0;
        while(N-- > 0) {
            String[] input = br.readLine().split(" ");
            if(Integer.parseInt(input[0]) == 1) {
                stack.push(new HW(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            }

            if(!stack.isEmpty()) {
                stack.peek().timeCost--;
                if (stack.peek().timeCost == 0) {
                    sum += stack.peek().score;
                    stack.pop();
                }
            }
        }

        System.out.println(sum);
    }
}
