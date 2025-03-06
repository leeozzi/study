package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(!str.equals("0")) {
            boolean flag = false;
            for(int i = 0 ; i <= str.length()/2 ; i++) {
//                System.out.println("앞 : " + str.charAt(i) + " 뒤 : " + str.charAt(str.length()-1-i));
                if(str.charAt(i) == str.charAt(str.length()-1-i)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if(!flag) System.out.println("no");
            else System.out.println("yes");

            str = br.readLine();
        }
    }
}
