package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }
        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int i = 0 ; i < m ; i++) {
            if(set.contains(Integer.parseInt(input[i])))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
