package workingon;

import java.io.*;

public class SWEA2805_농작물수확하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // map 만들어줄게
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                String[] strs = str.split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(strs[j]);
                }
            }

            // 시작점을 처음에 젤 중앙에 두고
            // 길이만큼 반복하면서 더해줘
            // 시작점 한 칸 땡기면서 길이 2개씩 늘려줘
            // i = N/2 번째 줄 도달하면, 이제 담부터 길이 -2씩 해줄 거야
            int sum = 0;
            int startpoint = N / 2;
            int len = 1;
            int plus = 2;
            int move = -1;
            for (int i = 0; i < N; i++) {
                for (int j = startpoint; j < startpoint + len - 1; j++) {
                    sum += map[i][startpoint];
                    System.out.print(map[i][startpoint] + " ");
                }

                startpoint += move;
                len += plus;

                if(startpoint < 0) {
                    startpoint = 1;
                    plus = -2;
                    move = 1;
                }
            }

            System.out.println();
            System.out.println(sum);
        }
    }
}
