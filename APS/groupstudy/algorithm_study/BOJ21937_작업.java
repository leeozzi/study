package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ21937_작업 {

    static List<List<Integer>> list = new ArrayList<>();
    static int X;
    static int res = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        vis = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list.get(B).add(A);
        }
        X = Integer.parseInt(br.readLine());

        work(X);
        System.out.println(res);
    }

    public static void work(int X) {
        queue.offer(X);
        vis[X] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
//            System.out.println(cur);
            for (int i = 0; i < list.get(cur).size(); i++) {
                int next = list.get(cur).get(i);
                if(!vis[next]) {
                    queue.offer(next);
                    res++;
                    vis[next] = true;
                }
            }
        }
    }
}
