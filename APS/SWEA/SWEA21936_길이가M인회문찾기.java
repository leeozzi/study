package SWEA;

import java.util.Scanner;

public class SWEA21936_길이가M인회문찾기 {
    /**
     * 길이가 M인 회문 찾기
     * <a href="https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZFkKmLa1zEDFAQW">...</a>
     */

    public static void main(String[] args) {
        // start = 0 -> n-m 까지 옮기면서
            // i = 0 -> m/2
                // start + i 랑 start + m - 1 - i 랑 같은지 비교
                // 달라지면 break
        // 반복문 끝나면 start 부터 start + m-1-i 까지 출력

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1 ; t <= T ; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String str = sc.next();
//            System.out.println(str);
            boolean flag = false;

            for(int i = 0 ; i <= N-M ; i++) {
//                System.out.println(i + "에서 시작하는 문자열");
                for ( int j = 0 ; j <= (M-1)/2 ; j++) {
                    if (str.charAt(i + j) == str.charAt(i + M - 1 - j)) {
                        flag = true;
//                        System.out.println(str.charAt(i + j) + " vs " + str.charAt(i + M - 1 - j));
                    } else {
                        flag = false;
//                        System.out.println(str.charAt(i + j) + " vs " + str.charAt(i + M - 1 - j));
                        break;
                    }
                }
                if(flag) {
//                    System.out.println("문자열 찾음 ! ");
                    System.out.print("#" + t  + " ");
                    for(int j = i ; j <= i + M - 1 ; j++) {
                        System.out.print(str.charAt(j));
                    }
                    System.out.println();
                    break;
                }
            }

            if(!flag) {
                System.out.println("#" + t  + " NONE");
            }




        }
    }
}
