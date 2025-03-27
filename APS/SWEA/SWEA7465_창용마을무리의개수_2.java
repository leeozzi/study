package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class SWEA7465_창용마을무리의개수_2 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            // 부모 저장해줄 배열
            parent = new int[N + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            // 간선 연결해주기
            for (int i = 0; i < M; i++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                a = findSet(a);
                b = findSet(b);

                if (a != b) {
                    union(a, b);
                }
            }

//            System.out.println(Arrays.toString(parent));
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < parent.length; i++) {
                set.add(findSet(i));
            }

            System.out.printf("#%d %d\n", t, set.size());
        }   // 테스트 케이스

    }

    private static void union(int x, int y) {
        parent[y] = parent[x];

    }

    private static int findSet(int x) {
        if (parent[x] != x) parent[x] = findSet(parent[x]);
        return parent[x];
    }
}
