package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10828_스택 {

    static int[] stack = new int[10000];
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }
            
            switch(op) {
                case "push" :
                    push(num);
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
                case "top":
                    top();
                    break;
            }

//            System.out.println("현재 size : " + size);
        }
    }

    private static void top() {
        if(size == 0)
            System.out.println(-1);
        else
            System.out.println(stack[size-1]);
//        System.out.println("top 연산 수행, 현재 stack : " + Arrays.toString(stack));
    }

    private static void empty() {
        if(size == 0)
            System.out.println(1);
        else
            System.out.println(0);
//        System.out.println("empty 연산 수행, 현재 stack : " + Arrays.toString(stack));
    }

    private static void size() {
        System.out.println(size);
//        System.out.println("size 연산 수행, 현재 stack : " + Arrays.toString(stack));
    }

    private static void pop() {
        if(size == 0)
            System.out.println(-1);
        else {
            System.out.println(stack[size-1]);
            stack[size-1] = 0;
            size--;
        }
//        System.out.println("pop 연산 수행, 현재 stack : " + Arrays.toString(stack));
    }

    private static void push(int num) {
        stack[size] = num;
        size++;
//        System.out.println("push 연산 수행, 현재 stack : " + Arrays.toString(stack));
    }
}
