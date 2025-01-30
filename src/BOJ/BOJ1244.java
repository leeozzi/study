package BOJ;

import java.util.Scanner;

public class BOJ1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int switchNum = sc.nextInt();
        int[] switches = new int[switchNum];

        for (int i = 0; i < switchNum; i++) {
            switches[i] = sc.nextInt();
        }

        int std = sc.nextInt();

        for (int i = 0; i < std; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();
            if (gender == 1) {
                maleAction(switches, num);
            } else {
                femaleAction(switches, num);
            }
        }

        printArr(switches);

    }   // main

    private static void printArr (int[] switches) {
        for(int i = 0 ; i < switches.length ; i++){
            if((i+1)% 20 == 0)
                System.out.print(switches[i] + "\n");
            else
                System.out.print(switches[i] + " ");
        }
    }

    private static int turnSwitch(int status) {
        if (status == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void maleAction(int[] switches, int num) {
        for (int i = 0; i < switches.length; i++) {
            if ((i + 1) % num == 0) {
                switches[i] = turnSwitch(switches[i]);
            }
        }
    }


    public static void femaleAction(int[] switches, int num) {
        switches[num - 1] = turnSwitch(switches[num - 1]);
        int reach = (num - 1) < (switches.length - num) ? num - 1 : switches.length - num;
        for (int i = 1; i <= reach; i++) {
            if(switches[num-1-i] == switches[num-1+i]){
                switches[num-1-i] = turnSwitch(switches[num-1-i]);
                switches[num-1+i] = turnSwitch(switches[num-1+i]);
            }
            else
                break;
        }
    }
}
