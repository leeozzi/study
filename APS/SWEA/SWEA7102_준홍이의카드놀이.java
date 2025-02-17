package SWEA;

import java.util.Scanner;

public class SWEA7102_준홍이의카드놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T ; t++) {
            System.out.print("#" + t + " ");
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] cnt = new int[N+M+1];

            for(int i = 1; i <= N ; i++){
                for(int j = 1; j <= M ; j++)
                    cnt[i+j] ++;
            }

            int max = 0;
            for(int i= 0 ; i < cnt.length; i++)
                max = Math.max(max, cnt[i]);


            for(int i = 0 ; i < cnt.length;i++) {
                if(cnt[i] == max)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
