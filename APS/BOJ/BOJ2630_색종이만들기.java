package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 * <a href="https://www.acmicpc.net/problem/2630">...</a>
 */

public class BOJ2630_색종이만들기 {

    static int N;
    static int[][] map;
    static boolean[][] vis;
    static int wcnt = 0;
    static int bcnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        vis = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        System.out.println(wcnt);
        System.out.println(bcnt);
    }

    public static void cut(int x, int y, int N) {
        if (N == 0) {
            return;
        }

        int start;
        if (!vis[x][y]) {
            start = map[x][y];

            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    if (start != map[i][j]) {
                        cut(x, y, N / 2);
                        cut(x + N / 2, y + N / 2, N / 2);
                        cut(x + N / 2, y, N / 2);
                        cut(x, y + N / 2, N / 2);
                        return;
                    }
                }
            }

            if (start == 0) {
                wcnt++;
            } else {
                bcnt++;
            }
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    vis[i][j] = true;
                }
            }
        }
    }
}
