package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    /**
     * OX 퀴즈
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i =0  ; i < n ; i++) {
            String line = br.readLine();
            int[] points = new int[line.length()];
            boolean flag = false;
            for(int j =0 ; j < line.length(); j++) {
                if(line.charAt(j) == 'O') {
                    points[j]++;
                    if(flag) {
                        points[j] = points[j-1] + 1;
                    }
                    flag = true;
                } else {
                    flag = false;
                }
            }
            int sum = 0;
            for (int j =0 ; j < points.length ; j++) {
                sum+= points[j];
            }
            System.out.println(sum);
        }




    }
}
