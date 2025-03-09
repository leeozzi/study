package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11651_좌표정렬하기2 {
    public static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.y != o.y){
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            pq.offer(new Node(x,y));
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
