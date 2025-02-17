package SWEA;

import java.util.Scanner;

public class SWEA6190_정곤이의단조증가하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            // 숫자들 배열에 담아주기
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int n = 0; n < N; n++) {
                arr[n] = sc.nextInt();
            }

            int max = -1;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int mul = arr[i] * arr[j];

                    // mul이 단조 증가하는 수인지 판단해 줄 거야
                    String mul2 = mul + "";
                    int loc = 0;
                    // 글자 하나씩 지나가면서 끝까지 증가하면 max 갱신
                    for (int l = 0; l < mul2.length() - 1; l++) {
                        if (mul2.charAt(l) > mul2.charAt(l + 1)) break; // 감소했다면 그만 봐
                        loc++;  // 증가 중이라면 loc 올려줘
                    }
                    // mul 길이 다 돌고 나서
                    if (loc == mul2.length() - 1) {    // loc가 끝까지 증가했으면
                        max = Math.max(max, mul);
                    }
                }
            }



            System.out.println("#" + t + " " + max);
        }
    }
}
