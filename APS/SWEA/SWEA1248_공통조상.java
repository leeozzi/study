package SWEA;

import java.util.*;

public class SWEA1248_공통조상 {

    static List<List<Integer>> tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++) {
            int V = sc.nextInt();   // 노드 개수
            int E = sc.nextInt();   //  간선 개수
            int sub1 = sc.nextInt();    // 공통조상 찾을 애 1
            int sub2 = sc.nextInt();    // 공통조상 찾을 애 2

            // 트리 만들어주기
            tree = new ArrayList<>();
            for(int i = 0 ; i < V+1; i++) {
                tree.add(new ArrayList<>());
            }
            for(int i = 0 ; i < E ; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                tree.get(a).add(b);
            }
            // 트리 테스트 출력
//            System.out.println(tree);

            //////////////////////
            // sub1 조상들 담아줄 배열
            List<Integer> parent1 = new ArrayList<>();
            findparent(parent1, sub1);
            // sub2 조상들 담아줄 배열
            List<Integer> parent2 = new ArrayList<>();
            findparent(parent2, sub2);

//            System.out.println(parent1);
//            System.out.println(parent2);

            // parent1이랑 parent2랑 비교하면서 같은 거 찾아줌
            int res = 999;
            for(int i = 0 ; i < parent1.size() ; i++) {
                if(parent2.contains(parent1.get(i))){
                    res = parent1.get(i);
                    break;
                }
            }

            // 음 이제 서브 트리 크기 세어줘야 해
            // res 기준으로...계속 타고 들어가면 될 듯? 자식 null 될 때까지
            System.out.printf("#%d %d %d", t, res, cntChild(res, 1));
            System.out.println();
        }

    }

    // 타고 올라가면서 조상 노드들 찾아줄 메서드
    private static void findparent(List<Integer> parent, int sub) {
        for(int i = 0 ; i < tree.size() ; i ++) {
            if(tree.get(i).contains(sub)){
                parent.add(i);
                findparent(parent, i);
            }
        }
    }

    // 내려가면서 카운트 해줄 메서드
    private static int cntChild(int start, int cnt){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);   //  3을 넣어
        while(!queue.isEmpty()) {
            int cur = queue.poll(); // 3을 꺼내서 cur로 정해줘

            if(tree.get(cur) != null) {
                for (int i = 0; i < tree.get(cur).size(); i++) {    // cur의 자식 노드들 넣어줘
                    queue.offer(tree.get(cur).get(i));
                    cnt++;
                }
            }

//            System.out.println(queue);
        }
        return cnt;
    }
}
