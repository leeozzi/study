package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class On_BOJ2493 {
    /**
     * 탑
     */

    static Stack<Integer> stack;
    static Stack<Integer> result;

    private static void tower() {
        int cur = stack.pop();
        while (!stack.isEmpty()) {
            int next = stack.peek();
            if (cur <= next) {
                result.add(stack.size());
                return;
            } else stack.pop();
        }


        result.add(0);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 두 번째 시도
        // 0. 일단 탑 높이 배열 받아주고
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        stack = new Stack<>();
        result = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                stack.add(arr[j]);  // stack에다가
            }
            tower();
            stack.clear();
//            System.out.println(result.size());
        }

        for(int i =0 ; i < result.size(); i++) {
            int num = result.pop();
            System.out.print(num + " ");
        }

        // 첫 번째 시도 -> 메모리 초과,,
        // 증말 어이없네 고작 정수배열 두 개 만들었는데 메모리 초과라니 너무하자너
//        int[] towers = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            towers[i] = sc.nextInt();
//        }
//        int[] receive = new int[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = i-1; j > 0; j--) {
//                if (towers[j] >= towers[i]) {
//                    receive[i] = j;
//                    break;
//                } else {
//                    receive[i] = 0;
//                }
//            }
//        }
//
//        for (int i = 1; i < receive.length; i++) {
//            System.out.print(receive[i] + " ");
//        }
    }


}
