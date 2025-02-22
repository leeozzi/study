package SWEA;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA2930_힙_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;
        int T = sc.nextInt();
        for(int t = 1; t <= T ; t++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            int N = sc.nextInt();
            for(int n = 0 ; n < N ; n++) {
                if(sc.nextInt() == 1){
                    pq.offer(sc.nextInt());
                } else {
                    if(!pq.isEmpty())
                        sb.append(pq.poll()).append(" ");
                    else
                        sb.append("-1 ");
                }
            }

            System.out.println(sb);
        }
    }
}
