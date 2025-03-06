package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14229_백만개의정수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] input2 = new int[input.length];
        for(int i= 0 ;i < input.length; i++){
            input2[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(input2);
        System.out.println(input2[500000]);
    }
}
