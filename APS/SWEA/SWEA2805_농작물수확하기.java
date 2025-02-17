package SWEA;

import java.io.*;

public class SWEA2805_농작물수확하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // map 만들어줄게
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                String[] strs = str.split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(strs[j]);
                }
            }

            int sum = 0;
            int len = 1;
            int startIdx = N / 2;
            for (int i = 0; i < N; i++) {   // 행 내려갈 때마다
                for(int j = startIdx ; j < startIdx + len ;j++) { // startIdx부터 길이만큼 더해줄 거야
                    sum += map[i][j];
                }

                if(i < N/2) {
                    len += 2;
                    startIdx--;
                } else {
                    len -=2;
                    startIdx++;
                }
//                System.out.println("현재 행 : " + i + " sum : " + sum);
            }


            System.out.printf("#%d %d\n", t, sum);

        }
    }
}
