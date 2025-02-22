package dataStructure.dfsbfs;

import java.util.*;

// 객체를 만들 때 데이터 타입을 명시하도록 하고
class Queue<T> {

    class Node<T> {
        // 같은 타입을 받는 노드를 하나 만들게요
        private T data; // 데이터를 선언하고
        private Node<T> next; // 다음 노드도 선언합니다

        // 생성자에서 해당 타입의 데이터를 받아서 내부 변수에 저장합니다
        public Node(T data) {
            this.data = data;
        }
    }

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
        return first == null ;// first가 null인지를 보내면 되죠?
    }

}



public class Test_Queue {
    public static void main(String[] args) {
        // 자 그럼 객체를 만들어서 우리가 만든 Queue를 사용해볼게요
        Queue<Integer> q = new Queue<Integer>();    // Integer 타입을 사용할 거예요.
        // q에 데이터를 담아볼게요
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        // 데이터를 꺼내오면서 출력합니다
        // 두 개 꺼내고 한 번 보고
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        // 한 번 더 꺼내고
        // 비었는지 확인하고
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        // 한 번 더 꺼내고
        // 또 비었는지 확인할게요
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}


