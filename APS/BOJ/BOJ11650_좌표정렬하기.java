package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ11650_좌표정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            String[] nodeinfo = br.readLine().split(" ");
            int x = Integer.parseInt(nodeinfo[0]);
            int y = Integer.parseInt(nodeinfo[1]);
            nodes[i] = new Node(x, y);
        }

        Arrays.sort(nodes);

        for(int i = 0 ; i < N ;i++){
            System.out.println(nodes[i]);
        }
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x != o.x)
                return this.x - o.x;
            else
                return this.y - o.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
