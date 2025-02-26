package workingon;

import java.io.*;
import java.util.*;

public class BOJ20166_문자열지옥에빠진호석 {
    /**
     * 문자열 지옥에 빠진 호석
     * <a href="https://www.acmicpc.net/problem/20166">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for(int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        String[] words = new String[K]; // 만들어야 하는 문자열

        for(int i = 0 ; i < K ; i++){
            words[i] = br.readLine();
        }

        ///////입력 받기 완료/////////
        
        for(int i = 0 ; i < K ; i++){
            String target = words[i];

            
        }


    }
}
