package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1991_트리순회 {
    /**
     * 트리 순회
     * <a href="https://www.acmicpc.net/problem/1991">...</a>
     */

    static HashMap<Character, char[]> hashmap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            String[] input= br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char[] child = {input[1].charAt(0), input[2].charAt(0)};
            hashmap.put(parent, child);
        }

        pre('A');
        System.out.println(sb);
        sb = new StringBuilder();
        in('A');
        System.out.println(sb);
        sb = new StringBuilder();
        post('A');
        System.out.println(sb);

    }

    private static void post(char cur) {
        char[] child = hashmap.get(cur);
        if(child[0] != '.'){
            post(child[0]);
        }
        if(child[1] != '.'){
            post(child[1]);
        }
        sb.append(cur);
    }

    private static void in(char cur) {
        char[] child = hashmap.get(cur);
        if(child[0] != '.'){
            in(child[0]);
        }
        sb.append(cur);
        if(child[1] != '.'){
            in(child[1]);
        }

    }

    private static void pre(char cur) {
        sb.append(cur);
        char[] child = hashmap.get(cur);
        if(child[0] != '.'){
            pre(child[0]);
        }
        if (child[1] != '.') {
            pre(child[1]);
        }
    }
}
