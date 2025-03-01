package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1181_단어정렬 {
    /**
     * 단어 정렬
     * <a href="https://www.acmicpc.net/problem/1181">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length())
                    return o1.length()-o2.length();
                else
                    return o1.compareTo(o2);
            }
        });

        for(int i = 0 ; i < N ; i++) {
            String word = br.readLine();
            if(!pq.contains(word))
                pq.offer(word);
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
