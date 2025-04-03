import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while(!input.equals("0 0")){
            String[] str = input.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if(a > b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            input = br.readLine();
        }

    }


}