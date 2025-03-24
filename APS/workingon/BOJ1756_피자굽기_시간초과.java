package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피자 굽기
 * <a href="https://acmicpc.net/problem/1756">...</a>
 */

public class BOJ1756_피자굽기_시간초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int D = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        // 오븐 깊이별 지름
        input = br.readLine().split(" ");
        int[] oven = new int[D];
        boolean[] vis = new boolean[D];
        for (int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(input[i]);
        }

        // 완성된 피자
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 내가 들어갈 수 있는 자리를 어떻게 찾지
        // 위에서 봐줘야 하나 밑에서 봐줘야 하나...
        // 위에서부터 봐줘야 할 것 같은데? 나보다 큰 애들 패스하고 작은 애 나타나면 거기 넣어주기. 또는, 맨 밑일 수 있음.
        // 그냥 배열로 만들어줘야 할 듯? 자료구조 쓸 필요 없을 거 같은데.

        int ovenIdx = D;
        int pizzaIdx = 0;


        while (pizzaIdx < N) {
            for (int i = 0; i < ovenIdx; i++) {
                if (oven[i] < arr[pizzaIdx]) {
                    ovenIdx = i;
                    break;
                } else if (i == ovenIdx - 1) {
                    ovenIdx = i;
                }
            }
            pizzaIdx++;
        }

        System.out.println(ovenIdx);


    }
}
