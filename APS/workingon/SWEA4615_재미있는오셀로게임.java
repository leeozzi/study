package workingon;

import java.util.Scanner;

public class SWEA4615_재미있는오셀로게임 {
	/*
	 * 1. 중앙에 네 개 배치하기 cntw = 2, cntb = 2 2. i, j, c 입력받기 3. 팔방탐색해서 반대 색깔 찾고, 그 방향으로
	 * 같은 색깔 나올 때까지 쭉 뒤집어주면서 cnt +1 4. 둘 다 팔방탐색했는데 놓을 곳 없거나 board에 0이 없으면 end 5. 돌
	 * 개수 비교
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // board 크기. 4, 6, 8 중 하나
			int M = sc.nextInt(); // 돌 놓는 횟수

			// board 만들기
			int[][] board = new int[N][N];

			// 초기값 세팅
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2][N / 2] = 2;

			// 이제 돌 놓아줄게
			while (M-- > 0) {
				System.out.println(M + "번 남음");
				// 돌 놓을 좌표
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;

				// 색깔. 1이 흑돌 2가 백돌
				int c = sc.nextInt();

				// 일단 돌 놔주고
				board[x][y] = c;

				// 이제 뒤집어줄게
				// 팔방탐색해서 반대 색깔 찾고,
				// 그 방향대로 가면서 뒤집어주기
				int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
				int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					int tempx = nx + dx[i];
					int tempy = ny + dy[i];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (board[nx][ny] != c && board[nx][ny] != 0) {
							boolean flag = false;

							while (tempx < N-1 && tempx > 0 && tempy < N-1 && tempy > 0) {
								tempx += dx[i];
								tempy += dy[i];
								if (board[tempx][tempy] == c) {
									flag = true;
								}
							}

							if (flag) {
								board[nx][ny] = c;
								System.out.println("뒤집힌 친구들 : " + nx + "," + ny);
								while (nx + dx[i] < N && nx + dx[i] >= 0 && ny + dy[i] < N && ny + dy[i] >= 0
										&& board[nx + dx[i]][ny + dy[i]] != c && board[nx + dx[i]][ny + dy[i]] != 0) {
									nx += dx[i];
									ny += dy[i];
									board[nx][ny] = c;
									System.out.println("뒤집힌 친구들 : " + nx + "," + ny);
								}
							}
						}
					}
				}

			}

			// 돌 다 놓고 나서 개수 카운팅

			int cntW = 0;
			int cntB = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1)
						cntB++;
					else if (board[i][j] == 2)
						cntW++;

					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("#" + t + " " + cntB + " " + cntW);

		}
	}
}
