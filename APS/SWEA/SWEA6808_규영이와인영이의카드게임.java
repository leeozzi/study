package SWEA;

import java.util.*;

public class SWEA6808_규영이와인영이의카드게임 {

    /**
     * 규영이와 인영이의 카드게임
     * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
     */

    /*
    인영이 카드를 하나 고를 때마다
    규영이 배열의 같은 인덱스에 담긴 숫자랑 비교해보고
    규영이 게 더 크면 score1에 더해줘
    인영이 게 더 크면 score2에 더해줘

    9개 다 채우면 score1이랑 score2 비교해서 score1이 더 크면 win++, score2가 더 크면 lose++;
     */

    static int[] arr = new int[9];
    static boolean[] visited;
    static int[] res;
    static int win, lose;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T ; t++) {

            win = 0 ;
            lose = 0;
            res = new int[9];
            visited = new boolean[19];            ;

            for (int i = 0; i < 9; i++) {
                arr[i] = sc.nextInt();
                visited[arr[i]] = true;
            }

            perm(0, 0, 0);

            System.out.printf("#%d %d %d\n", t, win, lose);
        }
    }

    private static void perm(int idx, int score1, int score2) {

//        System.out.println("idx : " + idx + " score1 : " + score1 + " score2 : " + score2);

        if(idx == 9) {
            if(score1 > score2) win++;
            else if (score1 < score2) lose++;

//            System.out.println("res : " + Arrays.toString(res));
            return;
        }

        for(int i = 1 ; i <= 18 ; i++){
            if(!visited[i]) {
                res[idx] = i;
                visited[i] = true;

                int temp1 = score1;
                int temp2 = score2;

                if(arr[idx] > res[idx]){
                    score1 += arr[idx] + res[idx];
                } else {
                    score2 += arr[idx] + res[idx];
                }

                perm(idx+1, score1, score2);
                visited[i] = false;
                score1 = temp1;
                score2 = temp2;
            }
        }

    }
}
