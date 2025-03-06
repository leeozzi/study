package workingon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21608_상어초등학교 {

    public static class Student {
        int stunum;
        List<Integer> fav;
        int r = -1;
        int c = -1;

        public Student(int stunum) {
            this.stunum = stunum;
            fav = new ArrayList<>();
        }

        @Override
        public String toString() {
            return stunum + " " + fav + "\n";
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 학생의 수
        Student[] students = new Student[N*N];  // 학생번호순으로 저장
        Queue<Student> queue = new LinkedList<>();  // 앉혀줄 순서

        for (int i = 0; i < N*N; i++) {
            String[] input = br.readLine().split(" ");
            Student st = new Student(Integer.parseInt(input[0]));
            for(int j = 1 ;j <= 4; j++) {
                st.fav.add(Integer.parseInt(input[j]));
            }
            students[st.stunum-1] = st;
            queue.add(st);
        }

        System.out.println("students 배열");
        System.out.println(Arrays.toString(students));
        System.out.println("자리 앉혀줄 순서 queue");
        System.out.println(queue);

        // 자리 잡아주기
        Student[][] classroom = new Student[N][N];

        // 첫 번째 친구면 1,1에 앉혀줘
        Student cur = queue.poll();
        cur.r = 1;
        cur.c = 1;
        classroom[cur.r][cur.c] = cur;

        // 처음 앉는 거 아니면
        while(!queue.isEmpty()){
            Student cur2 = queue.poll();
            // 친한 친구 중에 이미 앉은 애 있나 보자
            for(int i = 0 ; i < 4 ; i ++) {
                Student friend = students[cur2.fav.get(i)];
                if(friend.r != -1) {

                }
            }
        }
    }
}
