package dataStructure.dfsbfs;

import java.util.*;

class Queue_copy<T> {

    // Queue는 앞뒤로 주소를 알고 있어야 하니까 first랑 last 멤버변수 선언할게요
    private Node<T> first;  // 큐의 맨 앞 노드
    private Node<T> last;   // 큐의 맨 뒤 노드

    // 이제 함수들을 구현할게요
    // 추가하는 것부터
    public void add(T item) {
        // 추가할 T타입의 아이템 하나 받아서
        Node<T> t = new Node<T>(item); // 그 아이템을 가지고 노드를 하나 생성합니다

        if (last != null) { // 마지막 노드가 있다면
            last.next = t;  // 그 뒤에 새로 생성한 노드를 붙이고
        }
        last = t; // 이제 t가 마지막 노드가 되죠

        // 데이터가 없을 때는
        if (first == null) {    // 첫 번째 노드도 null 이죠 그런 경우엔
            first = last;   // 같은 값을 할당해줍니다
        }
    }   // add() 끝

    // remove 해볼까요?
    public T remove() {
        if (first == null) { // 혹시 Queue가 비어있으면
            throw new NoSuchElementException(); // Exception 에러를 던질게요
        }
        // 맨 앞에 있는 데이터를 반환하기 전에 그 다음 주소에 있는 애를 first로 만들어줘야 하니까
        T data = first.data;    // 데이터를 백업하고
        first = first.next; // 다음 애를 first로 만들어줍니다

        if (first == null) {    // first가 null이 됐을 때
            last = null;    // last도 같이 변경해주는 거 잊지 마세요
        }

        return data;    // 그리고 데이터를 반환합니다
    }   // remove() 끝

    // 이제 peek
    public T peek() {   // T 타입의 데이터를 반환하고요
        if (first == null) { // 마찬가지로 null 체크
            throw new NoSuchElementException(); // exception 에러를 던질게요
        }
        return first.data;  // null이 아니면 현재 first가 가리키고 있는 데이터를 반환하면 되죠
    }

    // 마지막으로 isEmpty
    public boolean isEmpty() {
        return first == null;// first가 null인지를 보내면 되죠?
    }

    class Node<T> {
        // 같은 타입을 받는 노드를 하나 만들게요
        private T data; // 데이터를 선언하고
        private Node<T> next; // 다음 노드도 선언합니다

        // 생성자에서 해당 타입의 데이터를 받아서 내부 변수에 저장합니다
        public Node(T data) {
            this.data = data;
        }
    }

}   // 지난 시간에 만든 Queue 그대로 사용해줄게요

// 노드가 필요하죠
class Node {
    int data;   // 데이터는 간단하게 정수로 할게요
    LinkedList<Node> adjacent;  // 인접한 노드들과의 관계는 LinkedList로 표현하겠습니다
    boolean marked; // 방문했는지 확인하는 플래그도 하나 선언합니다.

    Node(int data) {   // 노드의 생성자에서는
        this.data = data;   // 데이터를 받고
        this.marked = false;    // 마킹 플래그를 false로 초기화하고
        adjacent = new LinkedList<Node>();  // LinkedList를 준비시킵니다
    }
}

// 우선 Graph 클래스를 선언하고
class Graph {
    // 이제 그래프를 만들어볼게요
    Node[] nodes;   // 그래프에는 노드들을 저장할 배열이 필요하죠

    Graph(int size) {

        // 간단하게 표현하기 위해서 그래프의 노드 개수는 고정으로 할게요
        nodes = new Node[size]; // 노드 개수를 받아서 그 개수만큼 배열방을 만들어줍니다
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i); // 편의를 위해서 데이터와 배열방 번호를 동일하게 만들어줬어요
            // 0부터 개수-1 까지의 노드가 들어가겠죠?
        }
    }

    // 노드의 관계를 저장하는 함수
    void addEdge(int i1, int i2) {
        // 데이터가 인덱스랑 같으니까 받은 숫자를 인덱스로 사용할 수 있죠?
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        // 두 개의 노드의 adjacent(인접한 노드를 저장하는 LinkedList)에
        // 서로가 있는지 확인하고 없으면 서로 추가
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0); // dfs 함수를 그냥 호출하면 0번부터 시작하는 걸로 할게요
    }

    // 시작 index에서 dfs 순회 결과를 출력하는 함수
    void dfs(int index) {
        Node root = nodes[index];  // 해당 인덱스에서 노드를 가져오고
        Stack<Node> stack = new Stack<Node>();  // 스택을 하나 생성합니다
        stack.push(root);   // 현재 노드를 스택에 추가합니다
        root.marked = true; // 스택에 들어갔다고 표시합니다

        // 이제 스택에 데이터가 없을 때까지 반복하는 작업 시작합니다
        while (!stack.isEmpty()) {
            Node r = stack.pop();   // 스택에서 데이터를 하나 가져오고
            // 가져온 노드의 자식(adjacent 안의 요소들)들을 스택에 추가합니다
            for (Node n : r.adjacent) {
                if (n.marked == false) {    // 이때 스택에 추가되지 않은 노드들만 추가합니다
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    // 이제 이번엔 bfs
    void bfs() {
        bfs(0); // 마찬가지로 bfs가 인자 없이 호출되면 0번부터 시작할게요
    }

    void bfs(int index) {
        // bfs 함수에서 index로 받은 인자로
        Node root = nodes[index];   // node를 받아옵니다.
        Queue<Node> queue = new Queue<Node>();  // queue를 하나 생성하고요
        queue.add(root);    // 데이터를 큐에 추가합니다.
        root.marked = true; // 추가했다고 마킹하고요
        // 이번엔 큐가 다 비어있을 때까지 반복하는 작업 시작합니다
        while (!queue.isEmpty()) {
            Node r = queue.remove();   // 큐에서 데이터를 한 개 가져오고
            for (Node n : r.adjacent) {  // 큐에서 꺼낸 자식 노드들을 큐에 추가하는데요
                if (n.marked == false) {    // 이때 추가되지 않은 노드들만 추가합니다
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);   // 그리고 가져온 애는 출력합니다
        }
        // 마찬가지로 다시 while문 위로 올라가서 또 큐에서 데이터를 가져오고 하면서
        // 큐에 데이터가 한 개도 없을 때까지 반복합니다
    }

    // 이번엔 재귀호출을 이용한 dfsR를 구현해볼게요
    void dfsR(Node r) {
        // LinkedList가 Node의 주소를 가지고 있기 때문에
        // 재귀함수는 Node를 받는 형태가 되어야 합니다
        if (r == null) return;   // 받은 노드가 null일 때는 그냥 나가고요
        r.marked = true;    // 호출이 되었다고 노드에 마킹합니다
        visit(r);   // 자식들을 호출하기 전에 데이터를 먼저 출력하고
        // 호출이 되지 않은 자식들을 호출해줍니다
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    // 시작노드를 다양하게 테스트해보기 위해서 배열방에 인덱스를 받는 형태로도 하나 선언할게요
    // 인덱스를 받으면 노드를 찾아서 해당 노드를 시작으로 재귀호출을 진행합니다
    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    // 아무것도 넘기지 않았을 때는 0부터 시작할게요
    void dfsR() {
        dfsR(0);
    }


    // 방문할 때 출력해주는 함수 하나 만들게요
    void visit(Node n) {
        System.out.print(n.data + " ");
    }

}
/*

    0
  /
1 -- 3     7
|  / | \  /
| /  |  5
2 -- 4   \
          6 - 8

*/

public class Test_DFS {
    public static void main(String[] args) {
        Graph g = new Graph(9); // 그래프를 생성하고 9개의 노드를 만듭니다
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        // 관계 명시
//        g.dfs();
//        g.bfs();
//        g.dfs(3);
//        g.bfs(3);
        g.dfsR(3);
    }
}
