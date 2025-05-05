package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 맥주 마시면서 걸어가기
 * https://www.acmicpc.net/problem/9205
 */
public class BOJ9205_맥주마시면서걸어가기 {

    static int n;
    static Point[] points;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테케
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            points = new Point[2 + n];
            visited = new boolean[2 + n];

            st = new StringTokenizer(br.readLine());
            points[0] = new Point("상근이", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                points[i] = new Point("편의점", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            points[n + 1] = new Point("페스티벌", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            /// 입력 끝

            System.out.println(bfs(0));

        }   // 테케 반복 끝
    }   // 메인

    private static String bfs(int idx) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(points[idx]);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.name.equals("페스티벌")) return "happy";

            for(int i = 0 ; i < points.length ; i++) {
                if(!visited[i] && distance(cur, points[i]) <= 1000) {
                    queue.offer(points[i]);
                    visited[i] = true;
                }
            }
        }

        return "sad";
    }

    private static int distance(Point p1, Point p2) {
        int xGap = Math.abs(p1.x - p2.x);
        int yGap = Math.abs(p1.y - p2.y);

        return xGap + yGap;
    }

    public static class Point {
        String name;
        int x;
        int y;

        public Point(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }
}
