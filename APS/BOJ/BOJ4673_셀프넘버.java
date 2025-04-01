package BOJ;

import java.util.ArrayList;
import java.util.List;

/**
 * 셀프 넘버
 * <a href="https://www.acmicpc.net/problem/4673">...</a>
 */

public class BOJ4673_셀프넘버 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 1; i <= 10000 ; i++) {
            int dn = i;
            int temp = i;
            while (temp > 0) {
                dn += temp % 10;
                temp /= 10;
            }

            if(dn <= 10000)
                // dn의 생성자 i
                arr.get(dn).add(i);
        }

        for(int i = 1; i <= 10000 ; i++) {
            if(arr.get(i).isEmpty()) {
                System.out.println(i);
            }
        }

    }
}
