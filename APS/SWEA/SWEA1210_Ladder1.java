package SWEA;

import java.util.Scanner;

public class SWEA1210_Ladder1 {
	/**
	 * Ladder1
	 */

	static int[][] ladder;
	static int d = 0;

	public static void main(String[] args) {
		ladder = new int[100][100];

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();

			int r = -1;
			int c = -1;

			// map 만들기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					// 출구 위치 저장
					if (ladder[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}

			// 양 옆이 1이 아닌 동안 앞으로 이동한다
			// 양 옆 중 한 곳이 1이 되면 그쪽으로 이동한다
			// 위쪽으로 이동하면서 좌우 경로 탐색
			while (r > 0) {
				// 왼쪽 이동 (좌측에 1이 있으면 계속 이동)
				if (c > 0 && ladder[r][c - 1] == 1) {
					while (c > 0 && ladder[r][c - 1] == 1) {
						c--;
					}
				}
				// 오른쪽 이동 (우측에 1이 있으면 계속 이동)
				else if (c < 99 && ladder[r][c + 1] == 1) {
					while (c < 99 && ladder[r][c + 1] == 1) {
						c++;
					}
				}
				// 위로 이동
				r--;
			}

			// 결과 출력
			System.out.println("#" + tc + " " + c);
		}
	}
}
