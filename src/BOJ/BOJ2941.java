package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] kr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        boolean flag = true;
        while(flag) {
            for (int i = 0; i < kr.length; i++) {
                flag = false;
                if (line.contains(kr[i])) {
                    flag = true;
                    line = line.replace(kr[i], "#");
                }
            }
        }

        System.out.println(line.length());


    }
}
