package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 교환
 * <a href="https://acmicpc.net/problem/1522">...</a>
 */

public class BOJ1522_문자열교환 {
    /*
    슬라이딩 윈도우
    a 개수 구해주고 그 길이만큼을 슬라이딩하면서 가장 b가 적게 나오는 구간을 찾으면 됨
     */

    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = str + str;
        arr = str2.toCharArray();

        int acnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] == 'a') {
                acnt++;
            }
        }

        int pointer = 0;
        int ans = Integer.MAX_VALUE;
        while (pointer < str.length()) {
            int bcnt = 0;
            for (int i = pointer; i < pointer + acnt; i++) {
                if (arr[i] == 'b') bcnt++;
            }
            pointer++;
            ans = Math.min(ans, bcnt);
        }

        System.out.println(ans);

    }   // main 함수

}

