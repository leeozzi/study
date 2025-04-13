package groupstudy.algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int o = 0; o < N; o++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if ("I".equals(op)) {
                    map.put(val, map.getOrDefault(val, 0) + 1);
                } else if ("D".equals(op) && !map.isEmpty()) {
                    int target;
                    if (val == -1) {
                        target = map.firstKey();
                    } else {
                        target = map.lastKey();
                    }

//                    System.out.println("target : " + target);
                    if (map.get(target) == 1) {
                        map.remove(target);
                    } else {
                        map.put(target, map.get(target) - 1);
                    }
                }

//                System.out.println("op : " + op + " val : " + val);
//                System.out.println(map);
            }   // 연산

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }   // 테스트케이스
    }
}
