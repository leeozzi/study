package BOJ;

import java.util.*;

public class BOJ2309 {
    /**
     * 일곱 난쟁이
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nine = new int[9];
        for (int i = 0; i < 9; i++) {
            nine[i] = sc.nextInt();
        }

        int allsum = 0;
        for (int i = 0; i < 9; i++) {
            allsum += nine[i];
        }

        int gap = allsum - 100;
        int a ;
        int b ;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            a = nine[i];
            for (int j = i + 1; j < 9; j++) {
                b = nine[j];
                if (a + b == gap) {
                    for (int x = 0; x < 9; x++) {
                        if (nine[x] != a && nine[x] != b) {
                            res.add(nine[x]);
                        }
                    }

                    Collections.sort(res);
                    for(int y = 0 ; y < res.size() ; y++) {
                        System.out.println(res.get(y));
                    }
                    return;
                }
            }
        }


    }
}
