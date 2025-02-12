package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798_세로읽기 {
    /**
     * 세로읽기
     * <a href="https://www.acmicpc.net/problem/10798">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[5][];
        int maxlen = 0;
        for(int i = 0 ; i < 5 ; i++){
            String line = br.readLine();
            board[i] = new String[line.length()];
            for (int j= 0 ; j < line.length() ; j++) {
                board[i][j] = line.charAt(j) + "";
                maxlen = Math.max(line.length(), maxlen);
            }
        }

        for(int i= 0 ; i < maxlen ; i++) {
            for(int j = 0 ; j < 5;j++){
                if(board[j].length > i) {
                    System.out.print(board[j][i]);
                }
            }
        }
    }
}
