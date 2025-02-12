package BOJ;

import java.util.Scanner;

public class BOJ2798_블랙잭 {
    /**
     * 블랙잭
     * <a href="https://www.acmicpc.net/problem/2798">...</a>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열을 만들어놓고
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        // 돌면서 하나하나 비교
        int sum = 0;
        int max = sum;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i+1 ; j < nums.length; j++) {
                int b = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int c = nums[k];
                    sum = a + b + c;
                    if(max <= M && sum <= M) {
                        max = Math.max(sum, max);
                    }
                }
            }
        }

        System.out.println(max);


    }
}
