package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {   // 이 부분이 에라토스테네스의 체에서 가장 중요한 부분
                    // i*i부터 시작 -> 2면 2*2부터 시작, 3이면 3*3부터 시작
                    // 중복 연산 피하려고 이렇게 씀
                    // 3*3부터 시작하면 3*2는 건너뛸 수 있어 (이미 2에서 지워줌)

                    // j는 i의 배수들을 지나가면서 지워줘야 함
                    // -> j += i 하면 i = 3이라고 했을 때 j는 i*i인 9부터 9, 12, 15, 18,... 이렇게 지나가

                    // N == 30일 때 i가 6이면 i*i=36인데 N보다 커지니까 검사할 필요가 없어
                    // 그래서 i는 sqrt(N) 이하까지만 검사해주면 됨
                    isPrime[j] = false;
                }
            }
        }

        for(int i = M; i < isPrime.length;i++) {
            if(isPrime[i]) {
                System.out.println(i);
            }
        }




    }

}
