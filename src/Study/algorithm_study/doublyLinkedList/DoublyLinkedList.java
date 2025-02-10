package Study.algorithm_study.doublyLinkedList;

public class DoublyLinkedList implements ILinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(int index, Node node) {
        // 리스트가 비어있고 0번째에 넣으려고 하면 head랑 tail을 해당 노드로 설정
        if (size == 0 && index == 0) {
            this.head = node;
            this.tail = node;
        }

        // node의 index 번호를 지정한 걸로 넣어주고
        node.setIdx(index);
        size++;

        // 이전 노드의 next를 해당 노드로 지정

    }

    @Override
    public void remove(int value) {

    }

    @Override
    public void printAll() {

    }
}
