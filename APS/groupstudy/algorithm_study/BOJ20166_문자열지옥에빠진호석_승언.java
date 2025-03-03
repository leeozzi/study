package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20166_문자열지옥에빠진호석_승언 {

    /*
     * 아무곳에서나 시작
     * 0,0 시작 아님
     * 상하좌우대각 이동 가능
     * 재방문 가능
     * 알파벳 이어붙이기
     * 문자열 k개를 줌. 각 문자열마다 만들 수 있는 경우의 수 구하기
     * 경우의 수를 셀 때, 방문 순서가 다르면 다른 것
     * 배열 넘어갈 수 있음
     *
     * n, m 최대 10
     * 문자열 길이 최대 5
     * 문자열 개수 최대 1000
     *
     * 2중for문 하면서 하라는대로하면
     * 100 * 8^4 * 1000
     * 100000 3600 360,000,000 음?
     *
     * 2중for문하면서 5칸을 싹다 저장하기
     *      100 * 8^4
     *      저장하면서 map 1글자부터 다 넣어서 +1하기
     */


    static class Node {
        int x, y;
        String s;

        Node(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayDeque<Node> q = new ArrayDeque<>();
                q.offer(new Node(i, j, String.valueOf(board[i][j])));

                while (!q.isEmpty()) {
                    Node cur = q.peek();
                    q.poll();

                    if (mp.get(cur.s) == null) {
                        mp.put(cur.s, 1);
                    } else {
                        int curCount = mp.get(cur.s);
                        mp.put(cur.s, curCount + 1);
                    }

                    if (cur.s.length() == 5) continue;

                    for (int dir = 0; dir < 8; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0) nx = n - 1;
                        if (nx >= n) nx = 0;
                        if (ny < 0) ny = m - 1;
                        if (ny >= m) ny = 0;
                        q.offer(new Node(nx, ny, cur.s + board[nx][ny]));
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while (k-- > 0) {
            String input = br.readLine();
            if (mp.get(input) == null) {
                sb.append(0).append('\n');
            } else {
                sb.append(mp.get(input)).append('\n');
            }
        }
        System.out.println(sb);
    }
}