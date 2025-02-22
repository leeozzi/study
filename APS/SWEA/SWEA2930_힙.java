package SWEA;

import java.util.*;

public class SWEA2930_힙 {

    static int[] heap;
    static int heapSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T ; t++) {
            System.out.print("#" + t + " ");
            heap = new int[100001];
            heapSize = 0;

            int N = sc.nextInt();
            for(int n = 1; n <= N ; n++) {
                int op = sc.nextInt();
                if(op == 1) {
                    push(sc.nextInt());
                } else if (op == 2) {
                    System.out.print(pop() + " ");
                }
            }

            System.out.println();
        }

    }

    public static void push(int x) {

        heap[++heapSize] = x;   // 일단 냅다 넣어주고
        
        // 부모랑 자식 인덱스 일단 뽑아놔
        int p = heapSize / 2;
        int ch = heapSize; 

        // 이제 자리 찾아갈 거야 (올라감)
        while(p > 0 && heap[p] < heap[ch]){
            swap(p, ch);
            
            // 인덱스 바꿔줘야지
            ch = p;
            p = ch/2;   // 올라간 위치의 부모
        }
    }

    public static int pop() {
        if(heapSize == 0)
            return -1;

        int removed = heap[1];   // 제거할 루트
        heap[1] = heap[heapSize]; // 마지막 노드 올려주고
        heap[heapSize--] = 0;

        int p = 1;
        int ch = p * 2; // 왼쪽 노드
        if(ch+1 <= heapSize && heap[ch+1] > heap[ch])
            ch += 1;

        // 얘를 이제 내려줄 거야
        while(ch <= heapSize && heap[p] < heap[ch]){
            swap(p, ch);

            p = ch; // 내 인덱스 갱신
            ch = p * 2; // 내려간 자리의 자식

            if(ch+1 <= heapSize && heap[ch+1] > heap[ch])
                ch += 1;
        }

        return removed;
    }

    public static void swap(int idx1, int idx2) {
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
}
