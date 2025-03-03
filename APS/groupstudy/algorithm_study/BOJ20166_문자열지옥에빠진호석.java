package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ20166_문자열지옥에빠진호석 {
    /**
     * 문자열 지옥에 빠진 호석
     * <a href="https://www.acmicpc.net/problem/20166">...</a>
     */

    static char[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static HashMap<String, Integer> hashmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 행. 3~10
        int M = Integer.parseInt(st.nextToken());   // 열. 3~10
        int K = Integer.parseInt(st.nextToken());   // 신이 좋아하는 문자열의 개수. 1000개 이하
        // 찾아야하는 문자열 길이는 3~10

        ///////입력 받기 완료/////////

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char cur = line.charAt(j);
                map[i][j] = cur;
            }
        }

        for (int k = 0; k < K; k++) {   // 단어들 별로 세어줄게
            hashmap = new HashMap<>();
            String target = br.readLine();
            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == target.charAt(0)) {  // 시작 문자 같은 거 찾아서 dfs 돌려줄게
                        sum += dfs(new int[]{i, j}, target, 1);
                    }
                }
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    // loc 좌표 주변에서 target의 idx번째 char을 찾는 함수
    public static int dfs(int[] loc, String target, int idx) {
        if(idx == target.length()) {
            return 1;
        }

        int i = loc[0];
        int j = loc[1];

        if(hashmap.containsKey(i+","+j+","+idx)) {
            return hashmap.get(i+","+j+","+idx);
        }

        int count = 0;

        for (int d = 0; d < 8; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            nx = (nx + map.length) % map.length;
            ny = (ny + map[0].length) % map[0].length;

            if(map[nx][ny] == target.charAt(idx)){
                count += dfs(new int[] {nx, ny}, target, idx+1);
            }
        }

        hashmap.put(i+","+j+"," + idx,count);

        return count;
    }
}