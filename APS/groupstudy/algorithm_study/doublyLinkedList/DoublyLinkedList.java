package groupstudy.algorithm_study.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList implements ILinkedList {
     /*
     List<Node> list = new ArrayList<>();

     Node들을 나중에 출력하기 위해서 list를 써야하나 했는데
     생각해보니 그럴 거면 그냥 idx-1로 호출하면 되는데 왜 굳이 이걸 구현하겠나 싶었음.....
     아니나다를까 검색해서 찾아보니 리스트 쓰는 게 아니었군....
     */


    Node head;
    Node tail;
    int size = 0;

    @Override
    public void add(int index, Node node) {
        if (size == 0) {
            head = node;
            tail = node;
            head.prev = tail;
            tail.next = head;
            size++;
        } else {

            if (index != 0 && index != size) {
                Node cur = head;
                while (index-- > 0) {
                    // head에서부터 index 만큼 이동
                    Node next = cur.next;
                    cur = next;
                }

                Node temp = cur;    // 원래 index 위치에 있던 old node 따로 저장해두고

                // index-1 위치에 있는 node랑 연결해주기
                temp.prev.next = node;
                node.prev = temp.prev;

                // 아까 빼뒀던 old node랑 연결해주기
                temp.prev = node;
                node.next = temp;

                // node 추가됐으니까 size 키워주기
                size++;
            } else if (index == 0) {
                Node temp = head;
                head = node;

                temp.prev = node;
                node.next = temp;

                node.prev = tail;
                tail.next = node;

                size++;

            } else if (index == size) {
                Node temp = tail;
                tail = node;

                temp.next = node;
                node.prev = temp;

                node.next = head;
                head.prev = node;

                size++;

            }
        }


//        if (list.isEmpty()) {
//            list.add(node);
//            head = node;
//            tail = node;
//        } else {
//            Node temp = list.get(index);    // 원래 그 위치에 있던 old node를 따로 빼두고
//
//            if (index != 0) {
//                list.get(index - 1).next = node;  // 원하는 위치 바로 앞 node의 next를 new node로 저장
//                node.prev = list.get(index - 1);  // 원하는 위치 바로 앞 node를 new node의 prev으로 저장
//            }
//
//            list.set(index, node);  // 원하는 위치에 new node 넣어줌
//            temp.prev = node;   //  아까 빼둔 old node의 prev을 new node로 저장해주고
//            node.next = temp;   // new node의 next를 temp로 저장
//
//            /*
//            그 뒤로 다 하나씩 밀려야할 것 같은데...이렇게 하는 게 맞나...........
//            */
//            list.add(null); // 일단 배열 크기 하나 늘려주고
//            for (int i = list.size() - 1; i > index; i--) {
//                list.set(i + 1, list.get(i)); // 방금 new node 넣어준 자리 바로 뒤가 빌 때까지 한칸씩 뒤로 땡겨줌
//                list.set(index + 1, temp);    // 아까 빼놨던 old node 빈 자리에 넣어줌
//            }
//        }
    }


    @Override
    public void remove(int value) {
        Node cur = head;

        // 하나씩 이동하면서 value 같은 애 만나면 내 전에 애랑 내 뒤에 애랑 이어주고 나는 빠지기
        for (int i = 0; i < size; i++) {
            if (cur.value == value) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;

                size--;
                return;
            }
            Node next = cur.next;
            cur = next;
        }
    }

    @Override
    public void printAll() {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur + "\t");

            Node next = cur.next;
            cur = next;
        }
    }
}
