package BOJ;

import java.io.*;
import java.util.*;

public class BOJ13023_ABCDE {
    /**
     * ABCDE
     * <a href="https://www.acmicpc.net/problem/13023">...</a>
     */

    static HashMap<Integer, ArrayList<Integer>> hashmap;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static int maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);   // 사람 수
        int M = Integer.parseInt(input[1]);   // 친구 관계(간선) 수
        hashmap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if (!hashmap.containsKey(a))
                hashmap.put(a, new ArrayList<>());
            hashmap.get(a).add(b);

            if (!hashmap.containsKey(b))
                hashmap.put(b, new ArrayList<>());
            hashmap.get(b).add(a);
        }

//        System.out.println(hashmap);
        /// 관계 설정 끝

        for (int p : hashmap.keySet()) {
//            System.out.println("==============");
            visited = new boolean[N];
            maxDepth = 1;
            dfs(p, 1);
            if (maxDepth >= 5) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);


    }

    public static void dfs(int cur, int depth) {
        maxDepth = Math.max(maxDepth, depth);
//        System.out.println("현재 cur : " + cur + " 현재 depth : " + depth + " 현재 maxdepth : " + maxDepth);

        if(maxDepth >= 5) {
            return;
        }

        stack.add(cur);
        visited[cur] = true;

        for (int friend : hashmap.get(stack.pop())) {
            if (!visited[friend]) {
                dfs(friend, depth + 1);
                visited[friend] = false;
            }
        }
    }
}
