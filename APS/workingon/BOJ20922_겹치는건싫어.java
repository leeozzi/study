package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BOJ20922_겹치는건싫어 {
    /**
     * 겹치는 건 싫어
     * <a href="https://www.acmicpc.net/problem/20922">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            hashmap.put(arr[i], new ArrayList<>());
        }
        // 입력 받기 완료

        for(int i = 0 ;i < N ; i++) {
            hashmap.get(arr[i]).add(i); // 해당 숫자가 있는 인덱스 위치 다 저장
        }

        List<Integer> list = new ArrayList<>();
        for(int key : hashmap.keySet()) {
            if(hashmap.get(key).size() > K) {
                list.add(key);  // 쳐내줘야 할 애들 리스트 저장
            }
        }

        System.out.println(hashmap);
        System.out.println(list);

    }
}
