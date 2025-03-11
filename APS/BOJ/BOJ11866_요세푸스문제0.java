package BOJ;

import java.util.*;

public class BOJ11866_요세푸스문제0 {
    /**
     * 요세푸스 문제 0
     * <a href="https://www.acmicpc.net/problem/11866">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }
            arr.add(queue.poll());
        }

        System.out.print("<");
        for(int i= 0 ;i < arr.size()-1;i++) {
            System.out.print(arr.get(i) + ", ");
        }
        System.out.print(arr.get(arr.size()-1) + ">");

    }
}
