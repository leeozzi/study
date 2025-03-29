package SWEA;

import java.util.Scanner;

public class SWEA8275_햄스터_헤일리쌤2 {
    static int T, N, M, X, max;
    static int[][] recodes;
    static int[] cage;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            max = -1;
            N = sc.nextInt();// 우리수
            X = sc.nextInt();// 한 우리의 최대 X마리
            M = sc.nextInt();// 기록 M개
            recodes = new int[M][3];
            cage = new int[N + 1];
            ans = new int[N + 1];

            for (int i = 0; i < M; i++) {
                recodes[i][0] = sc.nextInt(); //시작점
                recodes[i][1] = sc.nextInt(); //끝점
                recodes[i][2] = sc.nextInt(); //합
            }

            DFS(1, 0, new int[N+1]);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            if (max == -1) {
                sb.append("-1");
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(ans[i]).append(" ");
                }
            }
            System.out.println(sb);
        }

    }

    static void DFS(int idx, int cnt, int[] sum) {
        if (idx > N) {

            //체크
            for (int i = 0; i < M; i++) {
                if(recodes[i][2] != sum[recodes[i][1]]-sum[recodes[i][0]-1])
                    return;
            }
            //갱신이 된다면 정답도 갱신
            if (max < cnt) {
                max = cnt;
                for (int i = 1; i <= N; i++)
                    ans[i] = cage[i];
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            cage[idx] = i;
            sum[idx] = sum[idx-1] + i;
            DFS(idx + 1, cnt + i, sum);
            sum[idx] = sum[idx-1] - i;
        }
    }
}
