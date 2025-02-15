package Study.algorithm_study.doublyLinkedList;

public class Test {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        DoublyLinkedList dll = new DoublyLinkedList();

        // add 테스트
        dll.add(0, node1);
        dll.add(1, node3);
        dll.add(2, node2);
        dll.add(3, node4);
        dll.add(0, node5);
        dll.add(5, node2);
        dll.printAll();

        System.out.println();

        // remove 테스트
        dll.remove(3);
        dll.printAll();
    }
}
