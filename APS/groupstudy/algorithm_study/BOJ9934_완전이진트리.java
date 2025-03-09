package groupstudy.algorithm_study;

import java.io.*;
import java.util.*;

public class BOJ9934_완전이진트리 {
    /**
     * 완전 이진 트리
     * <a href="https://www.acmicpc.net/problem/9934">...</a>
     */
    // 중위순회한 결과가 주어졌을 때, 트리를 알아내라
    // 가장 마지막 레벨을 제외한 모든 집은 왼쪽 자식과 오른쪽 자식을 갖는다  -> 완전 대칭

    static int[] arr;
    static List<Integer>[] tree;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[input.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }   // 입력 받기

        tree = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            tree[i] = new ArrayList<>();
        }

        makeTree(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            for(int j = 0 ; j < tree[i].size() ; j++){
                sb.append(tree[i].get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void makeTree(int start, int end, int depth) {

        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        tree[depth].add(arr[mid]);

        makeTree(start, mid - 1, depth + 1);
        makeTree(mid + 1, end, depth + 1);
    }
}
