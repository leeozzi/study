package workingon;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
 */

public class SWEA5656_벽돌깨기_chatGPT {

    static int N, W, H, minRemain;
    static int[][] map;
    static final int[] dx = {-1, 1, 0, 0}; // 상하좌우 방향벡터
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 구슬 개수
            W = sc.nextInt(); // 맵의 너비 (열 수)
            H = sc.nextInt(); // 맵의 높이 (행 수)
            map = new int[H][W];

            // 맵 입력
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            minRemain = Integer.MAX_VALUE; // 남은 벽돌의 최소 개수 초기화
            dropBalls(0, map); // DFS 시작

            System.out.println("#" + tc + " " + minRemain);
        }
    }

    // 구슬 떨어뜨리는 순열 DFS
    static void dropBalls(int depth, int[][] curMap) {
        if (depth == N) {
            int remain = countBlocks(curMap); // 남은 벽돌 수 계산
            minRemain = Math.min(minRemain, remain);
            return;
        }

        // 모든 열에 대해 구슬 떨어뜨리기 시도
        for (int col = 0; col < W; col++) {
            int row = 0;
            while (row < H && curMap[row][col] == 0) row++;

            if (row == H) {
                // 해당 열에 벽돌이 없는 경우 (구슬 낭비)
                dropBalls(depth + 1, copyMap(curMap));
            } else {
                // 벽돌이 있는 경우, 복사된 맵으로 시뮬레이션
                int[][] copied = copyMap(curMap);
                explode(copied, row, col); // 폭파 처리
                applyGravity(copied); // 중력 적용
                dropBalls(depth + 1, copied);
            }
        }
    }

    // 폭파 처리 (BFS 사용)
    static void explode(int[][] board, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        if (board[x][y] > 1) q.offer(new int[]{x, y, board[x][y]});
        board[x][y] = 0; // 현재 벽돌 제거

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                for (int dist = 1; dist < cur[2]; dist++) {
                    int nx = cur[0] + dx[d] * dist;
                    int ny = cur[1] + dy[d] * dist;
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W || board[nx][ny] == 0) continue;
                    if (board[nx][ny] > 1) q.offer(new int[]{nx, ny, board[nx][ny]});
                    board[nx][ny] = 0; // 벽돌 제거
                }
            }
        }
    }

    // 중력 처리 (아래로 벽돌 당기기)
    static void applyGravity(int[][] board) {
        for (int j = 0; j < W; j++) {
            int write = H - 1;
            for (int i = H - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    board[write--][j] = board[i][j];
                }
            }
            while (write >= 0) {
                board[write--][j] = 0;
            }
        }
    }

    // 남은 벽돌 수 세기
    static int countBlocks(int[][] board) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] != 0) count++;
            }
        }
        return count;
    }

    // 맵 복사
    static int[][] copyMap(int[][] original) {
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            newMap[i] = original[i].clone();
        }
        return newMap;
    }
}
