package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2943_토끼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 토끼의 수
        int M = Integer.parseInt(st.nextToken());   // 일수
        int K = (int) Math.sqrt(N); // 그룹 멤버 수
        int group;
        /* 이거 좀 더 간단하게 쓸 수 있는 방법 있는지 궁금!! 그룹 개수 찾는 거 */
        if(K*K == N) group = K;
        else group = K+1;

        int[] arr = new int[group];

        for (int m = 0; m < M; m++) {   // 일수...
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());   // 딸기의 수
            int A = Integer.parseInt(st.nextToken());   // 딸기를 주기 시작하는 토끼 번호


        }
    }
}
