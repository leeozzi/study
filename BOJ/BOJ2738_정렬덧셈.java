package BOJ;

import java.util.Scanner;

public class BOJ2738_정렬덧셈 {
    /**
     * 행렬 덧셈
     * <a href="https://www.acmicpc.net/problem/2738">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];

        for (int i =0 ; i < n ;i++) {
            for(int j = 0 ; j < m ; j++){
                matrix1[i][j] = sc.nextInt();
            }
        }

        for (int i =0 ; i < n ;i++) {
            for(int j = 0 ; j < m ; j++){
                matrix2[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n;i++) {
            for(int j=0; j<m ;j++){
                System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
