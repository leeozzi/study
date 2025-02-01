package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1620_try1_X {
    /**
     * 첫 번째 시도
     * 나는야 포켓몬 마스터 이다솜
     * <a href="https://www.acmicpc.net/problem/1620">...</a>
     *
     * 시간 초과...
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<String>> dic = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ArrayList<String> l = new ArrayList<>();
            l.add((i + 1) + "");
            l.add(br.readLine());
            dic.add(l);
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            for (ArrayList<String> element : dic) {
                if (element.get(0).equals(q)) {
                    bw.write(element.get(1) + "\n");
                } else if (element.get(1).equals(q)) {
                    bw.write(element.get(0) + "\n");
                }
            }
        }

        bw.flush();
        bw.close();

    }
}

