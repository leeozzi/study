package Study.algorithm_study.doublyLinkedList;

public class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
