package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진수 변환
 * https://www.acmicpc.net/problem/10829
 */


public class BOJ10829_이진수변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        System.out.println(Long.toBinaryString(N));
    }
}
