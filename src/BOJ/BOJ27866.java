package BOJ;

import java.util.Scanner;

public class BOJ27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = new char[line.length()];
        for (int i =0 ; i < chars.length; i++) {
            chars[i] = line.charAt(i);
        }
        int idx = sc.nextInt() - 1;
        System.out.println(chars[idx]);
    }
}
