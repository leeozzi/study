package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ1325_효율적인해킹 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[B].add(A);
        }

//        System.out.println(Arrays.toString(arr));
        int cnt = 0;
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1 ; i <= N ; i++) {
//            System.out.println("i = " + i + "일 때");
            visited = new boolean[N+1];
            if(!arr[i].isEmpty()) {
                int res = bfs(i);
                if (res > max) {
                    pq.clear();
                    pq.offer(i);
                    max = res;
//                    System.out.println("PQ : " + pq);
                } else if (max == res) {
                    pq.offer(i);
//                    System.out.println("PQ : " + pq);
                }
            }
        }

        while(!pq.isEmpty()) {
            System.out.print(pq.poll()+" ");
        }


    }

    public static int bfs(int start){
        queue.offer(start);
        visited[start] = true;
        int cnt = 0;

        while(!queue.isEmpty()) {
//            System.out.println("현재 큐 : "  + queue);
            int cur = queue.poll();
            cnt++;
            for(int i = 0 ; i < arr[cur].size() ; i++) {
                if(!visited[arr[cur].get(i)]) {
                    queue.offer(arr[cur].get(i));
                    visited[arr[cur].get(i)] = true;
                }
            }
        }

//        System.out.println("cnt : " + cnt);
        return cnt;
    }
}
