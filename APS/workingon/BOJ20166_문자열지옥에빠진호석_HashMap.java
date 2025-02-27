package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20166_문자열지옥에빠진호석_HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = input[j];
            }
        }

        HashMap<String, Integer> hashmap = new HashMap<>();
        for(int k = 0 ; k < K ; k++) {
            String word = br.readLine();
            hashmap.put(word, 0);
        }

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                for(int d = 0 ; d < 8 ; d++) {
                    for(int l = 0 ; l < 5 ; l++) {
                        int nx = i + dx[d]*l;
                        int ny = j + dy[d]*l;

                        if(nx >= 0 && ny >= 0 && nx < N && ny <M)
                            sb.append(board[nx%N][ny%M]);

                        if(hashmap.containsKey(String.valueOf(sb))) {
                            hashmap.put(String.valueOf(sb), hashmap.get(String.valueOf(sb)) + 1);
                        }
                    }
                    sb = new StringBuilder();
                }
            }
        }

        System.out.println(hashmap);
    }
}
