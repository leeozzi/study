package BOJ;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                ans += n / 5;
                break;

            } else {
                n -= 3;
                ans++;
                if (n % 5 == 0) {
                    ans += n / 5;
                    n = n % 5;
                    break;
                }
            }

            if (n <= 2) {
                ans = -1;
                break;
            }
        }

        System.out.println(ans);

        // 두 번째 시도 ..
//        // 1. 5의 배수인 경우
//        // 2. 3의 배수인 경우
//        // 3. 5씩 빼다보면 3의 배수가 나오는 경우
//        // 4. 3씩 빼다보면 5의 배수가 나오는 경우
//        if (n % 5 == 0) {
//            ans += n / 5;
//            System.out.println(ans);
//        } else if (n % 3 == 0) {
//            ans += n / 3;
//            System.out.println(ans);
//        } else {
//            while (n >= 0) {
//                if (n > 3) {
//                    n -= 3;
//                    ans++;
//                    if (n % 5 == 0) {
//                        ans += n / 5;
//                        System.out.println(ans);
//                        break;
//                    }
//                } else {
//                    ans = -1;
//                    System.out.println(ans);
//                    break;
//                }
//            }
//        }


//        첫 번째 시도 ~
//        int ans = 0;
//        if (n % 5 % 3 == 0) {
//            ans = n / 5;
//            ans += (n % 5) / 3;
//        } else if (n % 3 == 0) {
//            ans = n / 3;
//        } else {
//            ans = -1;
//        }
//
//        System.out.println(ans);
    }
}
