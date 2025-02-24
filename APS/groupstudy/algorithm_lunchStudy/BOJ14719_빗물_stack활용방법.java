package groupstudy.algorithm_lunchStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14719_빗물_stack활용방법 {
    /**
     * 빗물
     * <a href="http://acmicpc.net/problem/14719">...</a>
     * 누군가의 블로그에서 주워온 코드
     * <a href="https://blog.naver.com/hwang_gend/223264961006">...</a>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> blocks = new Stack<>();
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[w];
        int min = h + 1;
        for(int i = 0 ; i < w ; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            if(heights[i] < min) min = heights[i];
        }
        /// 여기까지가 input. 블록 높이까지 저장

        // 제일 낮은 벽을 전체에서 다 뺴줌 -> 연산 줄이기
        if(min != 0) {
            h -= min;
            for(int i = 0 ; i < w ; i++) {
                h = min;
            }
        }

        int water = 0;
        for(int i = h ; i >= 1; i--) {
            // 공간의 최대 높이에서부터 한 줄씩 내려가면서 검사
            for(int j = 1; j <= w ; j++) {
                if(heights[j-1] >= i) {  // i는 검사하는 라인. 블록이 여기보다 높이 쌓여있으면
                    if(blocks.isEmpty()) {  // 스택이 비어있다면 처음 맞딱뜨린 벽이다
                        blocks.push(j); // 2차원 좌표평면상 x축의 값인 j 넣어줌
                    }
                    else {  // 블록이 현재 검사 라인보다 높고, 스택이 비어있지 않다면
                        water += j - blocks.pop() - 1;
                        // x 좌표의 차이만큼 water에다 넣어줌
                        blocks.push(j); // 이 벽도 넣어줘야 다음 벽과 상호작용 가능
                    }
                }
            }
            blocks.pop();
        }
        System.out.println(water);

    }
}
