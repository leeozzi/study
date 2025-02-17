package workingon;

import java.io.*;

public class SWEA2805_농작물수확하기 {

    static int[][] map;
    static int[][] visited;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T ; t++) {
            // map 만들어줄게
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i = 0 ; i < N ; i++) {
                String str = br.readLine();
                String[] strs = str.split("");
                for(int j = 0 ; j < N ; j++){
                    map[i][j] = Integer.parseInt(strs[j]);
                }
            }

            // 중앙 기준으로 마름모로 퍼지면서 더해줄게
            // 중앙 위치 받아서 상하좌우 퍼지는 걸 함수로 돌려야겠다
            visited = new int[N][N];
            sum = 0;
            sum = map[N/2][N/2];
            spread(N/2, N/2);
            System.out.println(sum);
        }
    }

    public static void spread(int i, int j) {
        visited[i][j] = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int d = 0 ; d < 4 ; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(nx>=0  && ny >=0 && nx < map.length && ny < map.length){
                if(visited[nx][ny] != 1) {
                    sum += map[nx][ny];
                    spread(nx, ny);
                }
            }
        }
    }
}
