package groupstudy.algorithm_study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1,2,3 더하기 2
 * https://www.acmicpc.net/problem/12101
 */

public class BOJ12101_123더하기2 {
    static int N, K, cnt;
    static List<Integer> res;
    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 1, 2, 3 더해서 N이 되는 순열조합
        K = sc.nextInt();   // 사전순 K번째
        res = new ArrayList<>();
        sum = 0;

        perm();

        if (cnt < K) {
            System.out.println(-1);
        }
    }

    private static void perm() {
        if (sum > N || res.size() > N) return;

        if (sum == N) {
            cnt++;
            if (cnt == K) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < res.size() - 1; i++) {
                    sb.append(res.get(i)).append("+");
                }
                sb.append(res.get(res.size() - 1));
                System.out.println(sb);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            sum += i;
            res.add(i);
            perm();
            sum -= i;
            res.remove(res.size() - 1);
        }
    }
}
