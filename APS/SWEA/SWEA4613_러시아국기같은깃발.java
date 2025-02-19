package SWEA;

import java.util.Scanner;

public class SWEA4613_러시아국기같은깃발 {

	// 첫 번째 줄은 무조건 흰색이어야 해
	// -> 두 번째 줄 흰색할지 파랑할지 개수 세어 보고 정하자
	// -> 흰색이면 그 다음 줄에서도 방금 단계 반복하고
	// 파랑이면 그 다음 줄 파랑할지 빨강할지 정해야 해
	// 마지막 줄은 무조건 빨강이어야 함

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int mincnt = n*m ;	// 답 담아줄 변수 미리 선언

			// 일단 입력대로 이차원배열 만들어주기
			String[][] map = new String[n][m];
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				String[] split = line.split("");
				for (int j = 0; j < m; j++) {
					map[i][j] = split[j];
				}
			}

			// 각 줄마다 각 색깔로 바꿨을 때 몇 개씩 바꿔줘야 하는지 담아줄 것
			int[][] cnts = new int[n][3];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!map[i][j].equals("W")) {
						cnts[i][0]++;
					}

					if (!map[i][j].equals("B")) {
						cnts[i][1]++;
					}

					if (!map[i][j].equals("R")) {
						cnts[i][2]++;
					}
				}
			}

//			// cnts 배열 테스트 출력
//			for(int i= 0 ; i < n ; i++) {
//				for(int j = 0 ; j < 3; j++) {
//					System.out.print(cnts[i][j]);
//				}
//				System.out.println();
//			}

			// 약간 계단 오르기 문제처럼 풀어야 하나? 한 칸 갔을 때와 두 칸 갔을 때 구분했던 것처럼...
			// 근데 이때는 행이 계단이 아니라 색깔이 계단이어야지. 단계가 있잖아.

			// 맨 뒤에서부터 봤을 때 마지막은 무조건 R
			// 얘는 B에서 왔을 수도 있고, R에서 왔을 수도 있어
			// B에서 왔으면
			// W에서 왔을 수도 있고 B에서 왔을 수도 있고
			// W에서 왔으면 그 앞은 쭉 W여야 해
			// B에서 왔으면 그 앞은 W에서 왔을 수도 있고 B에서 왔을 수도 있어...
			// R에서 왔으면
			// B에서 왔을 수도 있고 R에서 왔을 수도 있어

			// 정리하자면
			// 1. 무조건 첫째줄은 W, 마지막 줄은 R
			// 2. 전체 행 개수 - W행 개수 - R행 개수 했을 때 남은 개수가 2 이상이면
			// 매번 W인지 B인지 or B인지 R인지 탐색해줘야 한다

			// B인 줄의 시작 위치와 마지막줄 위치가 관건
			// 시작 위치는 1 -> n-2
			// 끝 위치는 n-2 -> 1
			// 근데 둘이 똑같아지면 끝나야 함


			for (int startB = 1; startB <= n - 2; startB++) {
				for (int endB = n - 2; endB >= startB; endB--) {
					/* 
					 * startB == 1 이고 endB == n-2일 때
					 * cnts[0][0] + cnts[1][1] ~ cnts[n-2][1] + cnts[n-1][2]
					 * 
					 * startB == 2 이고 endB == n-2일 때
					 * cnts[0][0] + cnts[1][1] ~ cnts[n-2][1] + cnts[n-1][2]
					 * 
					 * ...
					 * 
					 * startB == n-2 이고 endB == n-2일 때
					 * 
					 * 까지 하고 나서
					 * startB = 2이고 endB == n-2일 때 부터 쭉....
					 */
					int cnt = 0;
					
					for(int i = 0; i < startB ; i++) {
						cnt += cnts[i][0];
					}
					
					for(int i = startB ; i <= endB ; i ++) {
						cnt += cnts[i][1];
					}
					
					

					for(int i = endB + 1 ; i <= n-1 ; i++) {
						cnt += cnts[i][2];
					}
					
					mincnt = Math.min(cnt, mincnt);
				}
			}
			
			System.out.println("#" + t + " " + mincnt);

		}

	}
}

// 아니 진심 멍청인가 마지막 red 조건 startB+1부터로 잡아줘서 오류남;;;;
// 코드 짤 때 덜렁거리는 거 어케 고치지 진짜.........
// 어쩐지 아무리 생각해도 논리는 다 맞는데 틀렸다더라.......짱나네 ㅋㅋ
