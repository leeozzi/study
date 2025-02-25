package workingon;

import java.io.*;
import java.util.*;

public class BOJ29160_나의FIFA팀가치는 {
    /**
     * 나의 FIFA 팀 가치는?
     * <a href="https://www.acmicpc.net/problem/29160">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] selected = new int[12];   // 선발 선수들의 가치 담아줄 거임

        // 포지션별 가치들 모아줄 Map
        Map<Integer, PriorityQueue<Integer>> hashmap = new HashMap<>();
        for (int i = 1; i <= 11; i++) {
            hashmap.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }

        // 포지션별로 가치들 넣어주기
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int position = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            hashmap.get(position).add(value);
        }

        while (K-- > 0) {
            for (int i = 1; i <= 11; i++) {
                if (!hashmap.get(i).isEmpty()) {
                    int max = hashmap.get(i).poll();
                    selected[i] = max;
                    hashmap.get(i).add(Math.max(max - 1, 0));
                }
            }
        }
//        System.out.println(Arrays.toString(selected));

        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            sum += selected[i];
        }

        System.out.println(sum);


    }
}
