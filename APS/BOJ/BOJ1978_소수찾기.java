package BOJ;

import java.io.*;
import java.util.ArrayList;

public class BOJ1978_소수찾기 {
    /**
     * 소수 찾기
     * <a href="https://www.acmicpc.net/problem/1978">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int cnt = 0;
        for(int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(input[i]);
            boolean flag = false;
//            for(int j = 2; j < num ; j++) { // 2부터 num-1까지 보면서
            for(int j = 2; j <= Math.sqrt(num) ; j++) { // 2부터 num-1까지 보면서
                if(num % j == 0) {  // 하나라도 나눠지는 수가 있으면
                    flag = true;    // flag 바꿔주고
                    break;  // break
                }
            }
            if(!flag && num != 1) cnt ++; // 다 봤는데 없으면 cnt 올려줘
        }

        System.out.println(cnt);
    }
}
