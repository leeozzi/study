package SWEA;

import java.util.Scanner;

public class SWEA6485_삼성시의버스노선 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T ; t++) {
            int[] arr = new int[5001];
            System.out.print("#" + t + " ");
            int N = sc.nextInt();   // 버스 노선
            for (int n = 1; n <= N; n++) {  // 노선마다 수행해줌
                int A = sc.nextInt();   // 해당 노선의 출발
                int B = sc.nextInt();   // 해당 노선의 도착
                for(int i = A ; i <= B ; i++) {
                    arr[i] ++;  //  정류장 지나가면서 cnt 하나씩 올려줘
                }
            }

            int P = sc.nextInt();   // 노선 개수 구해줄 정류장 개수
            for (int p = 1; p <= P; p++) {
                int C = sc.nextInt();
                System.out.print(arr[C] + " ");
            }

            System.out.println();
        }
    }
}
