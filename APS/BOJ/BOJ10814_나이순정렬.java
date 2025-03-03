package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class User {
    int num;
    int age;
    String name;

    public User(int num, int age, String name) {
        this.num = num;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class BOJ10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<User> pq = new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.age != o2.age) {
                    return o1.age - o2.age;
                } else {
                    return o1.num - o2.num;
                }
            }
        });
        int N = Integer.parseInt(br.readLine());
        for(int i= 0 ;i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            pq.add(new User(i, age, name));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
