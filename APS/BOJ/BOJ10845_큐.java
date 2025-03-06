package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10845_큐 {

    static List<Integer> queue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void back() {
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.get(queue.size() - 1)).append("\n");
        }
    }

    private static void front() {
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
        }else {
            sb.append(queue.get(0)).append("\n");
        }
    }

    private static void empty() {
        if(queue.isEmpty()) {
            sb.append(1 + "\n");
        } else {
            sb.append(0 + "\n");
        }
    }

    private static void size() {
        sb.append(queue.size()).append("\n");
    }

    private static void pop() {
        if(queue.isEmpty()){
            sb.append(-1 + "\n");
        } else {
            sb.append(queue.get(0)).append("\n");
            queue.remove(0);
        }
    }

    public static void push(int num){
        queue.add(num);
    }
}
