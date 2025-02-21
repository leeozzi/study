package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389_케빈베이컨의6단계법칙_도현오빠 {
    /**
     * 케빈 베이컨의 6단계 법칙
     * <a href="https://www.acmicpc.net/problem/1389">...</a>
     */
    static int N;
    static int M;
    static List<Integer>[] friendRelationship;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 유저의 수
        N = inputs[0];
        // 친구 관계의 수
        M = inputs[1];

        // 관계를 담아줄 리스트 타입 배열 생성
        friendRelationship = new ArrayList[N + 1];

        // 사람이 1부터 시작이므로 나의 편리를 위해 1부터 생성;
        for (int i = 1; i < N + 1; i++) {
            friendRelationship[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int[] friends = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int friendA = friends[0];
            int friendB = friends[1];
            // 양방향 관계 설정
            friendRelationship[friendA].add(friendB);
            friendRelationship[friendB].add(friendA);
        }

        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i < friendRelationship.length; i++) {
            int relationShip = 0;
            for (int j = 1; j < friendRelationship.length; j++) {

                if (j == i) {
                    continue;
                }

                relationShip += bfs(i, j);
            }
            if (map.containsKey(relationShip)) {
                continue;
            }
            map.put(relationShip, i);
        }

        System.out.println(map.get(map.keySet().stream().min(Integer::compareTo).get()));

    }

    public static int bfs(int oneself, int target) {
        // BFS를 위한 큐와 방문 체크 배열 초기화
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[friendRelationship.length];

        // 초기 상태: 시작 노드 추가 및 방문 처리
        queue.offer(oneself);
        visited[oneself] = true;

        int relationShip = 0; // 단계별 관계 거리

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 현재 큐의 사이즈만큼 반복 (현재 단계에서 탐색할 노드들)
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                // 타겟을 찾으면 현재 관계 거리 반환
                if (current == target) {
                    return relationShip;
                }

                // 현재 노드의 친구들을 큐에 추가
                for (int friend : friendRelationship[current]) {
                    if (!visited[friend]) {
                        queue.offer(friend);
                        visited[friend] = true;
                    }
                }
            }

            relationShip++;
        }
        return -1;
    }

}
