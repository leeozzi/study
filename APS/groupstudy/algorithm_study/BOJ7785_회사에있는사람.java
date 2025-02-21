package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ7785_회사에있는사람 {
    /**
     * 회사에 있는 사람
     * <a href="https://www.acmicpc.net/problem/7785">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> hashmap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String inout = log[1];
            hashmap.put(name, inout);
        }   // 이 반복문 돌고 나면 모든 사람의 최종 상태만 남을 거야

        List<String> names = new ArrayList<>();

        for(Map.Entry<String, String> entry : hashmap.entrySet()){  // HashMap의 순회 방법
            if(entry.getValue().equals("enter")) {
                names.add(entry.getKey());
            }
        }

        names.sort(Collections.reverseOrder()); // Collections.sort() 말고 이렇게도 쓸 수 있다
        for(String name : names) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
