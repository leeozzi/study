package groupstudy.algorithm_study;

import java.util.*;
import java.io.*;

public class BOJ16198_에너지모으기 {
    /**
     * 에너지 모으기
     * <a href="https://www.acmicpc.net/problem/16198">...</a>
     */

    static int N, maxCnt;  // 구슬 개수
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        // 입력 받음

        getEnergy(0);

        System.out.println(maxCnt);
    }

    private static void getEnergy(int cnt) {
        if (list.size() == 2) {
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int energy = list.get(i - 1) * list.get(i + 1);
            int temp = list.get(i);
            list.remove(i);
            getEnergy(cnt + energy);
            list.add(i, temp);
        }

    }
}
