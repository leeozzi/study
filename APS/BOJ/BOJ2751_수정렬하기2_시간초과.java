package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2751_수정렬하기2_시간초과 {
    /** 수 정렬하기 2
     * <a href="https://www.acmicpc.net/problem/2751">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue pq = new PriorityQueue();

        for(int i =0 ;i < N ; i++) {
            int num = Integer.parseInt(br.readLine());
            if(!pq.contains(num)) {
                pq.offer(num);
            }
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


    }
}
