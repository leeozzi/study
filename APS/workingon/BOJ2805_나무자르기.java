package workingon;

import java.io.*;
import java.util.*;

public class BOJ2805_나무자르기 {
    /**
     * <a href="https://www.acmicpc.net/problem/2805">...</a>
     */
    public static void main(String[] args) throws IOException {
        int res = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 나무 개수
        int M = Integer.parseInt(input[1]); // 구해야하는 나무 길이
        input = br.readLine().split(" ");

        // 나무들 높이 배열
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            arr.add(Integer.parseInt(input[i]));
        }

        // 일단 높은 순서대로 정렬
        Collections.sort(arr, Comparator.reverseOrder());
        System.out.println(arr);    /* 테스트 출력이에요 */

        // 갭 배열
        int[] gaparr = new int[N];
        for (int i = 1; i < N ; i++){
            int gap = arr.get(i-1) - arr.get(i);
            gaparr[i] = gap;
        }
        System.out.println(Arrays.toString(gaparr));

        // 갭 누적합으로 만들어주기 == 이 위치에서 잘랐을 때 얻을 수 있는 양
        for (int i = 1; i < N ; i++){
            gaparr[i] = gaparr[i-1] + gaparr[i]*i;
        }
        System.out.println(Arrays.toString(gaparr));

        // M 범위 찾기
        int maxidx = 0;
        int minidx = 0;
        for (int i = 1 ; i < N ; i++) {
            if (gaparr[i] > M) {
                minidx = i;
                maxidx = i-1;
                break;
            } else if (gaparr[i] == M) {
                res = arr.get(i);
                System.out.println(res);
                return;
            }
        }

        // arr.get(maxidx) 와 arr.get(minidx) 사이 어디에서 잘라줘야 함
        int min = arr.get(minidx);
        int max = arr.get(maxidx);

        // 처음에 minidx값+1에서 잘라보고, 더 크면 (minidx값+maxidx값)/2 해서 잘라보고...
        // 자르는 높이를 H라고 했을 때, arr.get(maxidx) 여기부터 잘려. 그 밑으론 고려 안 해도 돼
        int H = min + 1;
        while(H > arr.get(minidx) && H < arr.get(maxidx)) {

            // sum = maxidx 직전까지의 누적합 + (arr.get(maxidx)-H)*(maxidx+1)
            int sum = gaparr[maxidx] + (max - H) * (maxidx + 1);

            if(sum < M) {
                min = H;
                H = (H+arr.get(minidx))/2-1;
            }

            else if (sum > M) {
                max = H;
                H = (H+arr.get(maxidx))/2+1;
            }

            else {
                System.out.println(H);
                return;
            }

            System.out.println(H);
            System.out.println(sum);
        }
    }
}
