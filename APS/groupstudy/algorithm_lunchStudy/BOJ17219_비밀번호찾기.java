package groupstudy.algorithm_lunchStudy;

import java.util.*;
import java.io.*;

public class BOJ17219_비밀번호찾기 {
    /**
     * 비밀번호 찾기
     * <a href="https://www.acmicpc.net/problem/17219">...</a>
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashmap = new HashMap<>();

        // Hashmap에 이메일이랑 비밀번호 묶어주기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hashmap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            bw.write(hashmap.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
