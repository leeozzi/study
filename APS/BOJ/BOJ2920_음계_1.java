package BOJ;

import java.util.Scanner;

public class BOJ2920_음계_1 {
    /**
     * 음계
     * <a href="https://www.acmicpc.net/problem/2920">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ;i < 8 ; i++)
            sb.append(sc.next());

        if(String.valueOf(sb).equals("12345678"))
            System.out.println("ascending");
        else if(String.valueOf(sb).equals("87654321"))
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
