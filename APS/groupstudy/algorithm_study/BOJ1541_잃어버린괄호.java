package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-", true);
        int sum = 0;
        List<Integer> minusOp = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            // + 연산 더하기
            if (!str.equals("-")) {
                String[] plusOp = str.split("\\+");
                int plussum = 0;
                for (int i = 0; i < plusOp.length; i++) {
                    plussum += Integer.parseInt(plusOp[i]);
                }

                minusOp.add(plussum);
            }
        }

        for (int i = 0; i < minusOp.size(); i++) {
            if (i == 0) sum += minusOp.get(i);
            else sum -= minusOp.get(i);
        }

        System.out.println(sum);
    }
}
