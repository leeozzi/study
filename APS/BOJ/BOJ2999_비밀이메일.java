package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2999_비밀이메일 {
    public static void main(String[] args) {
        // N의 약수들 중에 두 개를 R과 C로 골라
        // 입력을 세로로 받아적은 다음
        // 가로로 읽으면 정답

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N = str.length();

        // 일단 R이랑 C 골라줄게
        // 약수들 담아줄 리스트
        // 최대 100글자니까 그냥 돌려줘도 될 것 같은데?
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) list.add(i);
        }

//        System.out.println(list);

        int R = 0;
        if (list.size() % 2 == 0) {
            R = list.get(list.size() / 2 - 1);
        } else {
            R = list.get((list.size() + 1) / 2 - 1);
        }
        int C = N / R;

//        System.out.println(N);
//        System.out.println(R + " " + C);


        // 이제 세로로 받아적을 거야
        char[][] map = new char[R][C];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                map[i][j] = str.charAt(idx);
                idx++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
        }

        System.out.println(sb);
    }
}
