package BOJ;

import java.util.Scanner;

public class BOJ1676_팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for(int i = 5 ; i <= n ; i*=5 ) {
            cnt += n/i;
        }
        System.out.println(cnt);
    }
}