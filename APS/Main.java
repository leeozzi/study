import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        System.out.println(sc.nextInt());
        for(int i =0 ;i < n ;i++) {
            for(int j = 0 ;j < n ; j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }


}