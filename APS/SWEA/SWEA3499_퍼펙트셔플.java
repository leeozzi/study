package SWEA;

import java.util.Scanner;

public class SWEA3499_퍼펙트셔플 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1 ; t <= T ; t++) {
            System.out.print("#" + t + " ") ;
            // 카드 리스트 만들어주기
            int N = sc.nextInt();
            String[] cards = new String[N];
            for(int i = 0 ; i < N ; i++) {
                cards[i] = sc.next();
            }

            // 반으로 쪼갠 카드리스트 두 개 만들어주기
            String[] cards1 = new String[(N+1)/2];  // 홀수일 경우 얘한테 하나 더 넣어줄 거야
            String[] cards2 = new String[N/2];

            for(int i = 0 ; i < (N+1)/2 ; i++) {
                cards1[i] = cards[i];
            }

            for(int i = (N+1)/2 ; i < N ; i++) {
                cards2[i-(N+1)/2] = cards[i];
            }

            for(int i= 0 ; i < (N+1)/2 ; i++) {
                System.out.print(cards1[i] + " ");
                if(i < N/2)
                    System.out.print(cards2[i] + " ");
            }
            System.out.println();
        }


    }
}
