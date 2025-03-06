package SWEA;

import java.util.Scanner;

public class SWEA1217_거듭제곱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = 1 ; t <= 10 ; t++) {
            sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.printf("#%d %d\n", t, pow(n,m));
        }
    }

    private static int pow(int n, int m) {
        int res = 1;

        if(m == 0) {
            return 1;
        }

        if(m % 2 == 0) {
            int temp = pow(n, m/2);
            res = res * temp * temp;
        } else {
            int temp = pow(n, m/2);
            res = res * temp * temp * n;
        }

        return res;
    }
}
