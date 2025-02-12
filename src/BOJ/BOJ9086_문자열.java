package BOJ;

import java.io.*;

public class BOJ9086_문자열 {
    /**
     * 문자열
     * <a href="https://www.acmicpc.net/problem/9086">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String testcase = br.readLine();
        int T = Integer.parseInt(testcase);
        for (int t = 1; t <= T; t++) {
            String line = br.readLine();
            bw.write(line.charAt(0) +""+ line.charAt(line.length()-1) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
