package Study.algorithm_study;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2493_탑_try2_X {
    /**
     * 탑
     * 메모리 초과
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        int[] towers = new int[n];
        for (int i = 0; i < n; i++) {
            towers[i] = sc.nextInt();
        }

        int[] receivers = new int[n];

        stack.push(towers[0]);
        receivers[0] = 0;
        for (int i = 1; i < n; i++) {
            // 만약 새로 넣으려는 친구가 방금 들어간 친구보다 작거나 같다면
            if (towers[i] <= stack.peek()) {
                // 방금 들어간 친구가 받아줄 것임
                receivers[i] = i;
                // 받아줄 친구 정하고나서 스택 넣어주기
                stack.push(towers[i]);
            } else {
                // 만약 새로 넣으려는 친구가 방금 들어간 친구보다 크다면
                for (int j = 1; j < i; j++) {
                    // 방금 넣은 친구를 받아준 탑은 누구?
                    // 그 탑은 나보다 높은지?
                    // 안 높으면 앞앞 친구 받아준 탑이랑 비교
                    // 나보다 높은 탑 위치 발견하면 그대로 break
                    if (receivers[i - j] == 0) {
                        receivers[i] = 0;
                    } else if (towers[receivers[i - j] - 1] > towers[i]) {
                        // receivers에 저장된 건 탑 번호라서 towers의 index보다 1씩 큼 -> towers에서 찾을 때 1씩 빼줘야 함
                        receivers[i] = receivers[i - j];    // 걔가 날 받아줄 것임
                        break;
                    } else {
                        receivers[i] = 0;   // 발견 못하면 0으로 끝나게 됨
                    }
                }
                stack.push(towers[i]);  // 나도 stack 들어가
            }
        }

        for (int i = 0; i < receivers.length; i++) {
            System.out.print((receivers[i]) + " ");
        }

    }


}
