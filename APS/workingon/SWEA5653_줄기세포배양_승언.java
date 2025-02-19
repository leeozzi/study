package workingon;

import java.util.*;

public class SWEA5653_줄기세포배양_승언 {

    // x시간 비활성 -> 활성 -> x시간생존 -> 죽음(자리는 씀)
    // 줄기세포 배양 겹치면 x가 높은 세포가 혼자 차지
    // 활성만 번식
    // 초기에는 비활성
    // 상태: 죽음, 활성, 비활성, 비어있음(0)
    // 활성/비활성 맵
    // 죽음 맵
    // int[] = {x, y, cur, hp, kValue}
    // 큐에 넣을때 죽은거 빼고는 다 넣어야 함
    // 비활성 -> cur감소시키고 다시 큐에 넣기
    // cur감소시킨게 0이면 cur을 hp로 바꾸고 활성상태로 바꾸기
    // 활성 -> cur 감소시키기
    // 0이면 죽음상태 -> 큐x
    // 0넘으면 큐에 다시 넣기

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int T = sc.nextInt();
        int SIZE = 1000;

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            Queue<int[]> q = new LinkedList<>();
            int[][] isActive = new int[SIZE][SIZE];
            int[][] isDead = new int[SIZE][SIZE];
            int[][] inputK = new int[SIZE][SIZE];

            int[][] board = new int[SIZE][SIZE];
            for (int i = (SIZE-n)/2; i < (SIZE-n)/2 + n; i++) {
                for (int j = (SIZE-m)/2; j < (SIZE-m)/2 + m; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] != 0) {
                        q.add(new int[]{i, j, board[i][j], board[i][j], 0});
                    }
                }
            }

            int curK = 0; // 사이클
            while (k-- > 0) {
                while (!q.isEmpty()) {
                    int[] cur = q.peek();
                    if (cur[4] != curK) break; // 사이클 통일일

                    // 바꿔치기 당한녀석 (검증)
                    if (cur[3] != board[cur[0]][cur[1]]) {
                        q.poll();
                        continue;
                    }

                    q.poll();

                    // 비활성
                    if (isActive[cur[0]][cur[1]] == 0) {
                        cur[2]--; // cur 감소
                        if (cur[2] == 0) {
                            isActive[cur[0]][cur[1]] = 1;
                            cur[2] = cur[3];
                        }
                        cur[4]++;
                        q.add(cur);
                    } else {
                        // 활성
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) continue;
                            if (board[nx][ny] == 0) { // 비어있는 경우
                                board[nx][ny] = cur[3];
                                q.add(new int[]{nx, ny, board[cur[0]][cur[1]], board[cur[0]][cur[1]], cur[4]+1});
                                inputK[nx][ny] = curK;
                            }
                            else if (inputK[nx][ny] == curK) { // 같은 사이클인 경우우
                                if (cur[3] > board[nx][ny]) {
                                    board[nx][ny] = cur[3];
                                    q.add(new int[]{nx, ny, board[cur[0]][cur[1]], board[cur[0]][cur[1]], cur[4]+1});
                                    inputK[nx][ny] = curK;
                                }
                            }

                        }
                        // 활성 후처리
                        cur[2]--;
                        if (cur[2] == 0) {
                            isDead[cur[0]][cur[1]] = 1;
                            isActive[cur[0]][cur[1]] = 0;
                        } else {
                            cur[4]++;
                            q.add(cur);
                        }
                    }
                }
                curK++;
            }

            int cnt = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isDead[i][j] == 0 && board[i][j] != 0) cnt++;
                }
            }
            sb.append('#');
            sb.append(t);
            sb.append(' ');
            sb.append(cnt);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
