package BOJ;

import java.util.Scanner;

public class BOJ3003 {
    public static void main(String[] args) {
        int[] wholeSet = {1, 1, 2, 2, 2, 8};
        int[] dhSet = new int[6];

        Scanner sc = new Scanner(System.in);
        for ( int  i= 0 ; i < 6 ; i++){
            dhSet[i] = sc.nextInt();
        }

        for (int i =0  ; i < 6 ; i++) {
            System.out.print(wholeSet[i] - dhSet[i] + " ");
        }
    }
}
