package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9934_완전이진트리 {
    /**
     * 완전 이진 트리
     * <a href="https://www.acmicpc.net/problem/9934">...</a>
     */
    // 중위순회한 결과가 주어졌을 때, 트리를 알아내라
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < K; i++) {

        }
    }
}
