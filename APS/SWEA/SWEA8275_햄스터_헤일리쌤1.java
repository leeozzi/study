package SWEA;

import java.util.Scanner;

public class SWEA8275_햄스터_헤일리쌤1 {
    static int T, N, M, X, max;

    static class Recode {
        int st, ed, sum;

        public Recode(int st, int ed, int sum) {
            this.st = st;
            this.ed = ed;
            this.sum = sum;
        }
    }

    static Recode[] recodes;
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
            recodes = new Recode[M];
            cage = new int[N + 1];
            ans = new int[N + 1];

            for (int i = 0; i < M; i++) {
                int st = sc.nextInt();
                int ed = sc.nextInt();
                int sum = sc.nextInt();
                recodes[i] = new Recode(st, ed, sum);
            }

            DFS(1, 0);

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

    static void DFS(int idx, int cnt) {
        if (idx > N) {

            for (int i = 0; i < M; i++) {
                Recode curr = recodes[i];
                int tmp = 0;
                for (int j = curr.st; j <= curr.ed; j++) {
                    tmp += cage[j];
                }
                if (tmp != curr.sum) {
                    return;
                }
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
            DFS(idx + 1, cnt + i);
        }
    }
}
