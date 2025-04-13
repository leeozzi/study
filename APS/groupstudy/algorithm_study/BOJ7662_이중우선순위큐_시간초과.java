package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7662_이중우선순위큐_시간초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            List<Integer> list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            for (int cal = 0; cal < N; cal++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if ("I".equals(op)) {
                    minHeap.add(num);
                    maxHeap.add(num);
                } else if ("D".equals(op)) {
                    if (!minHeap.isEmpty() && num == -1) {
                        int remove = minHeap.poll();
                        maxHeap.remove(remove);
                    } else if (!maxHeap.isEmpty() && num == 1) {
                        int remove = maxHeap.poll();
                        minHeap.remove(remove);
                    }
                }

//                System.out.println("op : " + op + " num : " + num);
//                System.out.println("maxHeap : " + maxHeap + " minHeap : " + minHeap);
//                System.out.println("list : " + list);
//                System.out.println();
            }


            if(maxHeap.isEmpty() || minHeap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxHeap.poll() + " " + minHeap.poll());
            }

        }
    }
}

