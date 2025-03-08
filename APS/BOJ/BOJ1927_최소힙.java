package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            long x = Integer.parseInt(br.readLine());
            if(x != 0)
                pq.offer(x);
            else {
                if(!pq.isEmpty())
                    System.out.println(pq.poll());
                else
                    System.out.println(0);
            }
        }
    }
}
