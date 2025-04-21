package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ25977_k개사과트리노드만으로배를최대로수확하기 {

    static int N, K, max;
    static List<List<Integer>> tree = new ArrayList<>();
    static List<Node> nodes = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        dp = new int[N][2];

        // 노드 만들기
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
            tree.add(new ArrayList<>());
        }

        // 간선 연결하기
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(p).add(c);
        }

        // 상태 넣어주기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nodes.get(i).status = Integer.parseInt(st.nextToken());
        }

//        System.out.println(tree);

        dfs(0, 0, 0, 0);

        System.out.println(max);

    }

    private static void dfs(int depth, int idx, int apple, int pear) {
        System.out.println("idx: " + idx + "으로 들어옴");

        if(apple == K) {
            System.out.println("사과 K개 모음");
            return;
        }

        if(nodes.get(idx).status == 1) apple += 1;
        else if (nodes.get(idx).status == 2) pear += 1;

        for (int i : tree.get(idx)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i, apple, pear);
                visited[i] = false;
            }
        }

        System.out.println("idx: " + idx + "에서 나옴");
    }

    public static class Node {
        int num;
        int status;     // 0이면 X, 1이면 사과, 2면 배

        public Node(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", status=" + status +
                    '}';
        }
    }
}
