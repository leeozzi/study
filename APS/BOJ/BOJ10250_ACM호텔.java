package BOJ;

import java.util.*;

public class BOJ10250_ACM호텔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int dis;
            int floor;
            if (N % H == 0) {
                dis = N / H;
                floor = H;
            } else {
                dis = N / H + 1;
                floor = N % H;
            }

            if (dis >= 10)
                System.out.println(floor + "" + dis);
            else
                System.out.println(floor + "0" + dis);
        }

    }

}
