package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ1759_암호만들기 {
    static char[] arr, res;
    static HashSet<Character> vowels = new HashSet<>();
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[0]);

        arr = new char[N];
        res = new char[M];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = input[i].charAt(0);
        }

        Arrays.sort(arr);

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        sb = new StringBuilder();
        makePW(0, 0, 0, 0);
        System.out.println(sb);
    }

    private static void makePW(int start, int depth, int vcnt, int ccnt) {
        if (depth == M) {
            if (vcnt != 0 && ccnt >= 2) {
                for (int i = 0; i < res.length; i++) {
                    sb.append(res[i]);
                }
                sb.append("\n");
                return;
            } else {
                return;
            }
        }


        for (int i = start; i < N; i++) {
            if (vowels.contains(arr[i])) {
                res[depth] = arr[i];
                makePW(i + 1, depth + 1, vcnt + 1, ccnt);
            } else {
                res[depth] = arr[i];
                makePW(i+1, depth+1, vcnt, ccnt+1);
            }
        }

    }
}
