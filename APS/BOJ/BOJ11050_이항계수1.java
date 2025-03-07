package BOJ;

import java.util.Scanner;

public class BOJ11050_이항계수1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(com(N, K));
    }

    public static int com(int N, int K) {
        if(K == N || K == 0) return 1;
        if(K == 1) return N;

        int res = com(N-1, K-1) + com(N-1, K);
        return res;
    }
}
