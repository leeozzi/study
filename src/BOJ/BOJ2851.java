package BOJ;

import java.util.Scanner;

public class BOJ2851 {
    /**
     * 슈퍼마리오
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0 ;
        int[] scores = new int[10];
        int small = 0;
        int big = 0;
        for (int i = 0; i < 10; i++) {
            scores[i] = sc.nextInt();
            sum += scores[i];
            small = sum - scores[i];
            big = sum;
            if(sum >= 100) {
                break;
            }
        }

        int res = Math.abs(small-100) >= Math.abs(big-100) ? big : small;
        System.out.println(res);
    }
}
