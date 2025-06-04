package BOJ;

import java.util.*;
import java.io.*;

public class BOJ30804_과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Map<Integer, Integer> count = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;

        while(r < N) {
            int fruit = arr[r];
            count.put(fruit, count.getOrDefault(fruit, 0) + 1);

            while(count.size() > 2) {
                int leftFruit = arr[l];
                count.put(leftFruit, count.get(leftFruit) - 1);

                if(count.get(leftFruit) == 0) {
                    count.remove(leftFruit);
                }

                l++;
            }

            r++;
            max = Math.max(max, r - l);
        }

        System.out.println(max);

    }
}
