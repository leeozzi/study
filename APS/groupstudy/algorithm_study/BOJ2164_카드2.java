package groupstudy.algorithm_study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164_카드2 {
    /**
     * 카드2
     * <a href="https://www.acmicpc.net/problem/2164">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            queue.offer(i);
        }
        while(queue.size() > 1){
            int remove = queue.poll();
            int move = queue.poll();
            queue.offer(move);
        }

        System.out.println(queue.poll());
    }
}
