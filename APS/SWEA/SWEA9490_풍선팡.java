package SWEA;

import java.util.Scanner;

public class SWEA9490_풍선팡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, 1, 0, -1 };

			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int num = arr[i][j];
					int sum = arr[i][j];
					
					for (int n = 1 ; n <= num ; n++) {
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d]*n;
							int ny = j + dy[d]*n;

							if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
								sum += arr[nx][ny];
							}
							
						}

					}
					max = Math.max(max, sum);
				}

			}

			System.out.println("#" + t + " " + max);
		}

	}
}
