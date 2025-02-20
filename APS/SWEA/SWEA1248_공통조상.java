package SWEA;

import java.util.*;
import java.io.*;

public class SWEA1248_공통조상 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++) {
            int V = sc.nextInt();   // 노드 개수
            int E = sc.nextInt();   //  간선 개수
            int sub1 = sc.nextInt();    // 공통조상 찾을 애 1
            int sub2 = sc.nextInt();    // 공통조상 찾을 애 2

            // 노드 배열 만들어줄게
            Node[] nodes = new Node[V+1];   // 노드 숫자를 이 배열에서의 인덱스로 쓸 거야
            for(int i = 1; i <= V ; i++) {  // 노드 개수만큼
                Node node = new Node() ;    // 노드 객체 생성
                nodes[i] = node;    // 노드 배열에 저장해 줘
            }
            
            // 이제 관계 연결해 줄 거야
            for(int i = 0 ; i < E ; i++) {  // 간선 개수 만큼 입력 받을 거야
                int p = sc.nextInt();
                int c = sc.nextInt();
                nodes[p].child.add(c);  // p의 자식 배열에 c 추가해주고
                nodes[c].parent = p;    // c의 부모는 p로 지정해줘
            }


        }

    }
}

class Node {
    int parent;
    ArrayList<Integer> child = new ArrayList<>();
}
