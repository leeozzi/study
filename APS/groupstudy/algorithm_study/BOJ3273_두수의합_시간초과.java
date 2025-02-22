package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ3273_두수의합_시간초과 {
    /**
     * 두 수의 합
     * <a href="https://www.acmicpc.net/problem/3273">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 리스트로 담아줘
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        int x = Integer.parseInt(br.readLine());    // 합
        int cnt = 0;
//        System.out.println(list);
        while (true) {
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) { // 리스트를 돌면서
                if (list.get(i) < x && x != list.get(i) * 2 && list.contains(x - list.get(i))) { // 나랑 만나서 합 채워줄 수 있는 애가 있으면
                    cnt++;  // 카운트 올려줘
//                System.out.println(list.get(i) + " " + (x - list.get(i)));
                    list.remove((Integer) (x - list.get(i)));
                    list.remove(list.get(i));
//                System.out.println(list);
                    flag = true;
                    break;
                }
            }
            if(!flag) break;
        }

        bw.write(cnt + "");
        bw.flush();
    }
}