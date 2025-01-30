package BOJ;

import java.util.Scanner;

public class BOJ10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] baskets = new int[N];

        for(int i = 0 ; i < N ; i++) {
            baskets[i] = i+1;
        }

        int M = sc.nextInt();


        for (int x = 0; x < M; x++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            int temp = baskets[i-1];
            baskets[i-1] = baskets[j-1];
            baskets[j-1] = temp;
        }

        for(int i = 0; i < N ; i++){
            System.out.print(baskets[i] + " ");
        }
    }
}
