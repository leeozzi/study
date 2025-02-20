package workingon;

import java.io.*;
import java.util.*;

public class BOJ1389_케빈베이컨의6단계법칙 {

    static int[][] board;
    static int[] vis;
    static int cnt;
    static int[][] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        board = new int[N + 1][N + 1];


        // 연결관계 표로 만들어주기
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            board[a][b] = 1;
            board[b][a] = 1;
        }

        dis = new int[N + 1][N + 1];
        vis = new int[N + 1];

        dfs(1);

        
        // 테스트 출력
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void dfs(int start) {
        System.out.println("start : "  + start);

        Stack<Integer> stack = new Stack<>();
        stack.push(start); // 시작점 일단 스택에 넣어주고
        vis[start] = 1; // 시작점 방문 체크해줘

        System.out.println(stack.pop());

        System.out.print("다음 돌려줄 애들 : ");
//            int cur = stack.pop(); // 일단 시작점 빼주고
        for (int i = 1; i < board.length; i++) {    // 연결된 애들 스택에 쭉 넣어줄 거야
            if (vis[i] != 1 && board[start][i] == 1) {   // 아직 방문한 적 없고 시작점이랑 연결된 애면
                System.out.print(i + " ");
                dis[start][i]++;
                dis[i][start]++;
                dfs(i);
            }
        }

        System.out.println("현재 스택 " + stack);



    }

}
