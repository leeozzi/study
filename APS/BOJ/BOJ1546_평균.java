package BOJ;

import java.util.Scanner;

public class BOJ1546_평균 {
    /**
     * 평균
     * <a href="https://www.acmicpc.net/problem/1546">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] scores = new double[N];
        int M = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            M = Math.max(M, (int)scores[i]);
        }


        double scoreSum = 0.0;
        for (int i = 0; i < N; i++) {
            scores[i] = scores[i] / M *100;
            scoreSum += scores[i];
        }
        double aver = scoreSum/N;
        System.out.println(aver);

    }
}
