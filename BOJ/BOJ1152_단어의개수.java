package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1152_단어의개수 {
    /**
     * 단어의 개수
     * <a href="https://www.acmicpc.net/problem/1152">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(st.countTokens());
    }
}
