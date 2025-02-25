package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14719_빗물_stack {
    /**
     * 빗물
     * <a href="https://www.acmicpc.net/problem/14719">...</a>
     *
     * 풀이법 참고
     * <a href="https://blog.naver.com/crm06217/222636933975">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 배열 만들어주기
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[W];
        for(int i = 0 ; i < W ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 물 담기 위해서 써줄 애들
        int water = 0;
        Stack<Integer> stack = new Stack<>();

        // 맨 위에서부터 내려갈 거야
        for(int i = H; i >= 1 ; i--) {
            for(int j = 0 ; j < W ; j++) {  // 가로로 하나씩 보면서
                if(arr[j] >= i) {   // i 보다 높거나 같아
                    if(stack.isEmpty()) {   // 스택이 비어있으면, 나보다 높은 애가 없었다는 거임
                        stack.push(j);  // 내 위치를 넣어줘
//                        System.out.println(stack);
                    }
                    else{   // 나보다 높은 애가 있어
//                        System.out.println("j : " + j + " stack.pop() : " + stack.peek() + " -1");
                        water += (j - stack.pop() - 1);
//                        System.out.println("water : " + water);
                        stack.push(j);
                    }
                }
            }
            stack.pop();
        }

        System.out.println(water);

    }
}
