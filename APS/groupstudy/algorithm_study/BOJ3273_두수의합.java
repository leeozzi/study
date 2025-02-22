package groupstudy.algorithm_study;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 개수
        String[] arr = br.readLine().split(" ");   // 수열 입력
        List<Integer> list = new ArrayList<>(); // 수열
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        Collections.sort(list);

        int x = Integer.parseInt(br.readLine());    // 최종 합

        int start = 0;
        int end = list.size() - 1;
        int cnt = 0;

        System.out.println(list);
        for (int i = start; i < list.size(); i++) {
            for (int j = end; j > i; j--) {
                System.out.println("현재 start 위치 : " + list.get(i) + " 현재 end 위치 : " + list.get(j));
                if (list.get(i) + list.get(j) == x) {
                    cnt++;
                    end = j;
                    System.out.println(list.get(i) + "+" + list.get(j));
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
