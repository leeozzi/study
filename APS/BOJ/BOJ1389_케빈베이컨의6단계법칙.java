package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1389_케빈베이컨의6단계법칙 {
    /**
     * 케빈 베이컨의 6단계 법칙
     * <a href="https://www.acmicpc.net/problem/1389">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 노드의 수
        int M = Integer.parseInt(input[1]); // 간선의 수

        // graph 만들기
        List<List<Integer>> graph = new ArrayList<>();
        for(int  i = 0 ; i <= N ; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < M ; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

//        System.out.println(graph);

        int[][] distance = new int[N+1][N+1];   // 거리 담아줄 배열. 행 숫자 ~ 각 열까지의 거리

        // 순서대로 bfs 돌려주면서 한 칸 내려갈 때마다 depth 늘려줄 거야
        for(int i = 1; i <= N ; i++) {
            int[] vis = new int[N+1];
            Queue<Integer> queue = new LinkedList<>();
            int depth = 1;
            queue.offer(i);
            vis[i] = 1;
            /// 이하 while 문 부분은 GPT 선생님의 도움을 받음
            while (!queue.isEmpty()) {
                int size = queue.size();    /// 이 부분이 추가 됨...
                for (int s = 0; s < size; s++) {
                    int cur = queue.poll();
                    for (int e : graph.get(cur)) {
                        if (vis[e] == 0) {
                            queue.offer(e);
                            vis[e] = 1; // 방문 체크
                            distance[i][e] = depth; // 거리 저장
                        }
                    }
                }
                depth++; // 한 레벨 끝나면 증가
            }
//            while(!queue.isEmpty()){
//                for(int e : graph.get(queue.poll())) {
//                    if(vis[e] != 1) {
//                        queue.offer(e);
//                        vis[e] = 0;
//                        distance[i][e] = depth;
//                    }
//                }
//
//                depth++;
//            }

        }

        // 이제 행별로 합 구해서 min 구해줘
        int min = Integer.MAX_VALUE;
        int minidx = -1;
        for(int i= 1 ; i <= N ; i++ ) {
            int sum = 0;
            for(int j = 1; j <= N ; j++){
                sum += distance[i][j];
            }

            if(sum < min) {
                min = sum;
                minidx = i;
            }

            /// 같은 점수면 작은 값을 출력한다는 이 부분도 내가 놓쳤음..
            else if (sum == min && i < minidx) {
                minidx = i;
            }
        }

        System.out.println(minidx);

    }

}
