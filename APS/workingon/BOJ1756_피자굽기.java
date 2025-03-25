package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1756_피자굽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int D = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] oven = new int[D];
        int[] pizza = new int[N];
        int[] res = new int[N];

        input = br.readLine().split(" ");
        for(int i = 0 ; i < D ; i++) {
            oven[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            pizza[i] = Integer.parseInt(input[i]);
        }

        ///////// 입력 받기 완료 //////////

        // 나보다 크거나 같은 층 && 다음 층은 나보다 작거나, bottom이어야 함
        // 일단 피자 세 개 다 가지고 올라가면서
        
        // 칸 올라가서, 일단 첫 번째 피자랑 비교.
            // 첫 번째보다 작으면 넣지 말고 넘어가
            // 작지 않으면 넣어줘
        // 또 올라가서, 세 개 다 비교
            // 첫 번째보다 작으면 첫 번째 피자 자리 0 으로 비워주고 넘어가
            // 첫 번째보다 크거나 같으면 두번째 피자랑 비교
                // 두 번째 들어갈 수 있으면 넣어줘
                // 두 번째보다 작으면 넣지 말고 넘어가
        // 또 올라가서
            // 첫 번째보다 작으면 첫 번째랑 두 번재 피자 자리 0으로 비워주고 넘어가
            // 첫 번째보다 크거나 같으면 두 번재 피자랑 비교
                // 두 번째보다 작으면 넣지 말고 넘어가
                // 두 번째 들어갈 수 있으면 넣어줘

        for(int i = D - 1 ; i >= 0 ; i--) {
            int cur = oven[i];
            if(cur >= pizza[0]) {

            }
        }
    }
}
