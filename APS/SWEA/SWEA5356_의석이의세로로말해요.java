package SWEA;

import java.util.Scanner;

public class SWEA5356_의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 2차원 배열을 만들어야 할 거야
			// 길이를 어떻게 정해주지? -> 길이 15 이하래 걍 다 15로 맞추자
			String[][] map = new String[15][15];

			// 각 테스트 케이스는 다섯 줄
			for (int i = 0; i < 5; i++) {
				// 한 줄 읽어오면 쪼개주고
				String line = sc.next();
				String[] parts = line.split("");
				// 쪼갠 거 차곡차곡 넣어줌
				for (int j = 0; j < parts.length; j++) {
					map[i][j] = parts[j];
				}
			}

			// 이제 출력해줘야 해
			System.out.print("#" + t + " ");
			
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 15; i++) {
					if (map[i][j] != null) {
						System.out.print(map[i][j]);
					}
				}
			}
			
			System.out.println();

		}
	}
}
