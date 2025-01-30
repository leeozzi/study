package BOJ;

import java.util.Scanner;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();

        int last =1;
        int i = 0;
        int cnt = 0;
        while (true) {
            if(last>=n) {
                cnt++;
                break;
            } else if (last <n) {
                i++;
                cnt++;
                last = last +(6*i);
            }
        }

        System.out.println(cnt);
    }
}
