package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] arr = new long[6];
        for(int i= 0 ;i < 6 ; i ++) {
            arr[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");
        long T = Long.parseLong(input[0]);
        long P = Long.parseLong(input[1]);

        long Tset = 0;
        long Pset = N/P;

        for(int i = 0 ;i < 6 ; i++) {
            if(arr[i] % T == 0) {
                Tset += arr[i]/T;
            } else {
                Tset += arr[i]/T+1;
            }
        }

        System.out.println(Tset);
        System.out.println(Pset + " " + N%P);

    }
}
