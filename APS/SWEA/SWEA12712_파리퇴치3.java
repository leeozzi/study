package SWEA;

import java.util.Scanner;

public class SWEA12712_파리퇴치3 {
    /**
     * 파리퇴치3
     * <a href="https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AXuARWAqDkQDFARa">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

//            for(int i= 0 ; i < N ; i++) {
//                for(int j = 0 ; j < N ; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            int max = 0;

            int[] dx1 = {-1, 0, 1, 0};
            int[] dy1 = {0, 1, 0, -1};

            int[] dx2 = {-1, -1, 1, 1};
            int[] dy2 = {-1, 1, -1, 1};

            // 한 위치에서 +, x 둘 다 검사해야 함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    System.out.println("현재 위치 : (" + i + "," + j + ")");
                    // + 검사
                    int plussum = map[i][j];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx1[d] * m;
                            int ny = j + dy1[d] * m;

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
//                                System.out.print(map[nx][ny] + " ");
                                plussum += map[nx][ny];
//                                System.out.println("현재 plussum : " + plussum);
                            }
                        }
//                        System.out.println();

                    }

                    // x 검사
                    int xsum = map[i][j];
                    for (int m = 1; m < M; m++) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx2[d] * m;
                            int ny = j + dy2[d] * m;

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                xsum += map[nx][ny];
                            }

                        }
                    }

                    // 두 개 중 더 큰 값 비교
//                    System.out.println("현재 위치 : (" + i + "," + j + ")");
//                    System.out.println("xsum : " + xsum + " plussum : " + plussum);
                    max = Math.max(max, Math.max(xsum, plussum));
                }

            }

            System.out.println("#" + t + " " + max);
        }
    }
}
