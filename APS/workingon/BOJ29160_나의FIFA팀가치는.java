package workingon;

import java.io.*;
import java.util.*;

public class BOJ29160_나의FIFA팀가치는 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] selected = new int[12];   // 선발 선수들의 가치 담아줄 거임

        // 포지션별 가치들 모아줄 Map
        Map<Integer, ArrayList<Integer>> hashmap = new HashMap<>();
        for (int i = 1; i <= 11; i++) {
            hashmap.put(i, new ArrayList<>());
        }

        // 포지션별로 가치들 넣어주기
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int position = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            hashmap.get(position).add(value);
        }

//        System.out.println(Arrays.toString(selected));


        // 가치들 정렬해줘
        for (int i = 1; i <= 11; i++) {
            Collections.sort(hashmap.get(i), Comparator.reverseOrder());
        }

        int num = K*2;
        while(num-- > 0) {
            // 3월에 젤 높은 애들 선발해줘
            for(int i = 1; i <= 11; i++) {
                if (!hashmap.get(i).isEmpty()) {
                    int val = hashmap.get(i).get(0);
                    selected[i] = val;
                    hashmap.get(i).set(0, Math.max(val-1, 0));   // 선발된 애들 하나씩 깎아줌
                    if(hashmap.get(i).size() >= 2 && hashmap.get(i).get(0) < hashmap.get(i).get(1)){
                        int temp = hashmap.get(i).get(0);
                        hashmap.get(i).set(0, hashmap.get(i).get(1));
                        hashmap.get(i).set(1, temp);
                    }
                }

                else {
                    selected[i] = 0;
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= 11; i++){
            sum += selected[i];
        }
        System.out.println(sum);

    }
}
