package BOJ;

import java.util.Scanner;

public class BOJ1592_영식이와친구들 {
    /**
     * 영식이와 친구들
     * https://www.acmicpc.net/problem/1592
     */

    /*
    받은 횟수 아니고 던진 횟수…
    처음에 1번이 받은 1은 던진 횟수는 0이므로 1 빼주는 게 맞음
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 사람 숫자
        int m = sc.nextInt();   // 공 던지는 횟수
        int l = sc.nextInt();   // 공 던질 대상과의 거리

        int[] catchcnts = new int[n + 1];

        int cur = 1;
        catchcnts[cur] = 1;
        while (catchcnts[cur] < m) {
            if (catchcnts[cur] % 2 == 1) {
                if ( cur + l <= n ) cur = cur + l;
                else cur = cur + l - n;
                catchcnts[cur] ++ ;
            } else {
                if ( cur - l > 0) cur = cur - l;
                else cur = n - (l - cur);
                catchcnts[cur] ++ ;
            }
        }

        int sum = 0;
        for (int i= 0 ;i < catchcnts.length ; i ++) {
            sum += catchcnts[i];
        }
        System.out.println(sum-1);


    }
}
