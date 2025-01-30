package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ3052 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        List<Integer> remainder = new ArrayList();

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            if(!remainder.contains(num%42))
                remainder.add(num%42);
        }

        System.out.println(remainder.size());
    }
}
