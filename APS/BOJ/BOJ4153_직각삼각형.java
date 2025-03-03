package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            if(str.equals("0 0 0")) {
                return;
            }
            int[] lines = new int[3];
            int max = 0;
            for(int i= 0 ;i < 3 ;i ++) {
                lines[i] = Integer.parseInt(st.nextToken());
                max = Math.max(lines[i], max);
            }

            int sum = 0;
            for(int i= 0 ;i < 3; i ++) {
                if(lines[i] != max) {
                    sum += lines[i]*lines[i];
                }
            }

            if(sum == max*max)
                System.out.println("right");
            else
                System.out.println("wrong");

        }
    }
}
