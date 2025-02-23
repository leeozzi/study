

// 승언이가 외우면 좋을 것 같다고 준 코드

import java.io.*;
import java.util.*;;

// Permutation (순열)
public class 중복없는순열_승언 {
    // PermMain class
    static int N = 4, R = 3, C = 0; // N: 전체 개수 R: 선택 개수
    static int[] a = {1, 2, 3, 4}, b = new int[R];
    static boolean[] v = new boolean[N]; // 방문 여부

    public static void main(String[] args) {
        C = 0;
        perm(0);
        System.out.println(C);
    }

    static void perm(int cnt) { // cnt == index, 재귀 depth
        if (cnt == R) {
            System.out.println(Arrays.toString(b)); C++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1);
            v[i] = false;
        }
    }
}
