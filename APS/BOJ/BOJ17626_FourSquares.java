package BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ17626_FourSquares {
    public static void main(String[] args) throws IOException {
        // 이거 구냥...N 주어지면 N보다 작거나 같은 수 중에 제일 큰 제곱수 빼주고
        // 그 남은 수에 저장된 값 더하면 되겠는데...
        // 음...그럼 일단 필요한 게...제곱수 리스트? n이 5만까지니까. 그 직전의 가장 큰 제곱수가 223 * 223
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] square = new int[224];
        for (int i = 1; i < 224; i++) {
            square[i] = i * i;
        }

//        // 배열 탐색하면서 N보다 작은 가장 큰 제곱수 찾아서 빼줘
//        int num = 0;
//        for (int i = 0; i < square.length; i++) {
//            if(N < square[i]) {
//                num = square[i-1];
//                break;
//            }
//        }

        // 냅다 하나씩 정리해주면
        int[] dp = new int[N+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        dp[4] = 1;
//        dp[5] = 2;
//        dp[6] = 3;
//        dp[7] = 4;
//        dp[8] = 2;

        for(int i = 1; i <= N ; i++) {
            dp[i] = i;
        }
        // dp[n] 은 제곱수 하나 지날 때마다 그거 제곱수 빼준 나머지를 dp에서 찾아서 1 더해주면 돼
        // 긍까... 1 지났으니까 2, 3에서는 1 빼준 나머지를 dp에서 찾아서 1 더해주고
        // 4 지나면 5,6...에서는 4 빼준 나머지를 인덱스로 찾아서 1 더해주고...

        
        // 이 방식은 안 돼... 왜냐면 중간에서 제곱수 두 개로 표현되는 경우도 있는 거잖아
        // 무작정 제일 큰 제곱수를 빼준다고 해서 되는 게 아니었어
//        for(int i = 4 ; i < dp.length; i++) {
//            int sqrt = (int) Math.sqrt(i) * (int) Math.sqrt(i);
//            dp[i] = dp[i - sqrt] + 1;
//        }


        // 문제 또 잘 안 읽은 탓에 힌트 하나 놓침
        // 모든 자연수는 "넷 또는 그 이하의 제곱수의 합"으로 표현될 수 있다

        ///  여기부터 GPT가 도와줌
        // 1부터 N 이하의 제곱수를 순차적으로 확인
        // j에서 현재 제곱수를 뺀 나머지 숫자의 dp값 + 1을 비교
        for(int i = 1; i * i <= N ; i++) {  ///  오... i*i<=N으로 조건 주는 방법은 또 생각 못했네
            int sqr = i*i;  /// 현재 제곱수  // 헉 그렇네 이렇게 하면 나보다 제곱수를 하나씩 늘려가면서 아래 for문을 돌겠구나
            for (int j = sqr ; j <= N ; j++) {
                dp[j] = Math.min(dp[j-sqr]+1, dp[j]);
                // i == 1이고 j == sqr 일 때
            }
        }

        System.out.println(dp[N]);

    }
}
