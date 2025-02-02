package Study.algorithm_study;

import java.io.*;

public class BOJ3986_try1_X {
    /**
     * 좋은 단어
     * <a href="https://www.acmicpc.net/problem/3986">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean flagA;
        boolean flagB;
        int cnt = 0;

        while (n-- > 0) {
            String w = br.readLine();
            flagA = false;
            flagB = false;
            int ended = -1;

            for (int i = 0; i < w.length(); i++) {
                if (flagA && flagB && i >= 3) {
                    // 아래 조건 왜 넣어줬냐면 ABBA 같은 경우 한 번 더 기회주려고...
                    // 해보니까 BABBAB는 처리를 못하는군....
                    if(w.charAt(i) != w.charAt(i-1)){
                        ended = i;
                        break;
                    }
                }

                if (w.charAt(i) == 'A' && flagA) {
                    flagA = false;
                } else if (w.charAt(i) == 'A' && !flagA) {
                    flagA = true;
                } else if (w.charAt(i) == 'B' && flagB) {
                    flagB = false;
                } else if (w.charAt(i) == 'B' && !flagB) {
                    flagB = true;
                }

            }

            System.out.println(ended);
        }

        System.out.println(cnt);
    }


}
