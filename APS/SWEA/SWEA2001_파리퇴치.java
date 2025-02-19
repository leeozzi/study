package SWEA;

import java.util.Scanner;

public class SWEA2001_파리퇴치 {
	/**
	 * 파리퇴치
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 배열 만들어주기
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 계산
			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					/*
					 arr[i+1][j]; 
					 arr[i+2][j];
					 ...
					 arr[i+M-1][j];
					 
					 arr[i][j]
					 arr[i][j+1]
					 arr[i][j+2]
					 ...
					 arr[i][j+M-1]
					 */
					int sum = 0;
					
					
					// cur 기준으로 M*M 순회
					// 근데 첨에 이거 while(M-- == 0)으로 풀려다가 그럼 대각선으로만 가서 실패함...
					for(int n = 0 ; n < M ; n ++) {
						for(int m = 0 ; m < M ; m++) {
							if(i+n < N && j+m < N)
								sum += arr[i+n][j+m];
						}
					}
										
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + t + " " + max);

		}
	}
}
