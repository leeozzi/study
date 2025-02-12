package BOJ;

import java.util.Scanner;

public class BOJ1316_그룹단어체커 {
    /**
     * 그룹 단어 체커
     * <a href="https://www.acmicpc.net/problem/1316">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 0 ;
        for (int i = 0; i < t; i++) {
            String word = sc.next();
            cnt += checker(word);
        }
        System.out.println(cnt);
    }

    private static int checker(String word) {
        for (int i = 0; i < word.length(); i++) {
            boolean flag = false;
            int flagcnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if (!flag && word.charAt(i) == word.charAt(j)){
                    flag = true;
                    flagcnt ++;
                } else if (word.charAt(i) == word.charAt(j)){
                    flag = true;
                } else if (word.charAt(i) != word.charAt(j)) {
                    flag = false;
                }

                if (flagcnt == 2) {
                    return 0;
                }
//                System.out.println(word.charAt(i) + "랑 " + word.charAt(j)+ " 비교");
//                System.out.println(flag);
//                System.out.println(flagcnt);
            }
        }

        return 1;
    }
}
