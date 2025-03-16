package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000001];
        for (int i = 0; i < arr.length; i++) {
            String str = String.valueOf(i);
            char[] chars = str.toCharArray();
            int sum = i;
            for (int j = 0; j < chars.length; j++) {
                sum += Character.getNumericValue(chars[j]);
            }
            arr[i] = sum;
        }

        int num = Integer.parseInt(br.readLine());
        for(int i= 0 ;i < arr.length ;i++) {
            if(arr[i] == num) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
