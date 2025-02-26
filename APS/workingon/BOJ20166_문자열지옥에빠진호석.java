package workingon;

import java.io.*;
import java.util.*;

public class BOJ20166_문자열지옥에빠진호석 {
    /**
     * 문자열 지옥에 빠진 호석
     * <a href="https://www.acmicpc.net/problem/20166">...</a>
     */

    static char[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 행. 3~10
        int M = Integer.parseInt(st.nextToken());   // 열. 3~10
        int K = Integer.parseInt(st.nextToken());   // 신이 좋아하는 문자열의 개수. 1000개 이하 
        // 찾아야하는 문자열 길이는 3~10

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        ///////입력 받기 완료/////////

        Queue<Character> queue = new LinkedList<>();
        int cnt = 0;

        for(int k = 0 ; k < K ; k++) {
            String target = br.readLine();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    queue.offer(map[i][j]);     // 가로로 한 줄 넣어주고
                }

                cnt += cntwords(queue, target);
                queue.clear();
            }
        }
    }

    private static int cntwords(Queue<Character> queue, String target) {
        int cnt = 0;
        sb = new StringBuilder();

        for(int i = 0 ; i < queue.size() ; i++) {
            char cur = queue.poll();
            if(cur == target.charAt(i)) {
                sb.append(cur);
            }
        }

        return cnt;
    }
}
