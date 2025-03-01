package BOJ;

import java.util.Scanner;

public class BOJ2920_음계_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        boolean flag = true;
        for (int i = 0; i < 8 - 1; i++) {
            if(arr[i] < arr[i+1]) {
                if(!flag) {
                    System.out.println("mixed");
                    return;
                }
                flag = true;
            } else if(arr[i] > arr[i+1]){
                if(i != 0 && flag){
                    System.out.println("mixed");
                    return;
                }
                flag = false;
            }
        }
        if(flag) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}
