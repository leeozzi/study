package workingon;

import java.util.Scanner;

public class SWEA5653_줄기세포배양 {
    /**
     * 줄기세포 배양
     * <a href="https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZT3mDEKMc3HBIOK&contestProbId=AWXRJ8EKe48DFAUo&probBoxId=AZT3mDEKMc7HBIOK&type=PROBLEM&problemBoxTitle=%EC%A0%9C1%ED%9A%8C+IM+%EB%8C%80%EB%B9%84&problemBoxCnt=3">...</a>
     */
    public static void main(String[] args) {
        // x시간 후 비활성 -> 활성, 번식
        // 또 x시간 후 활성 -> 죽음
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();   //  배양 시간

            // board는 생명력 정보 담아주고
            // status 변화 시키면서 현재 상태 파악할 거야
            int sizeN = N + 2 * K;
            int sizeM = M + 2 * K;
            int[][] board = new int[sizeN][sizeM];
            int[][] status = new int[sizeN][sizeM];

            // 냅다 크게 만든 board 중앙에 초기 상태 넣어줌


            // 시간 한 시간씩 깎으면서 동작들 수행
            // 생명력을 갖고 있으면 1씩 깎여나감
            // 원래 0이 아니었는데 방금 1 깎여서 0이 됐다면
            // 죽은 거니까 -1로 체크
            // 번식 가능 여부체크할 때 포함 안 시키려고
        }
    }
}
