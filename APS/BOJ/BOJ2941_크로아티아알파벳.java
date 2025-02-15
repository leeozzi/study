package BOJ;

import java.io.*;

public class BOJ2941_크로아티아알파벳 {
    /**
     * 크로아티아 알파벳
     * <a href="https://www.acmicpc.net/problem/2941">...</a>
     */
    /*
    chat gpt 도움 받은 부분
    - flag 사용, replace 사용
     */
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
