package BOJ;

import java.io.*;

public class BOJ10989_수정렬하기3 {
    /**
     * 수 정렬하기 3
     * <a href="https://acmicpc.net/problem/10989">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for(int i = 0 ; i < n ; i++) {
            cnt[Integer.parseInt(br.readLine())] ++;
        }

        for(int i = 0 ; i < 10001 ; i++) {
            while(cnt[i] > 0){
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }

        System.out.println(sb);

    }
}
