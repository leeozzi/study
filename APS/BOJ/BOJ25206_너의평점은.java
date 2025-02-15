package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 너의 평점은
 * <a href="https://www.acmicpc.net/problem/25206">...</a>
 */

class Subject {
    String subject;
    double credit;
    String grade;

    public Subject(String subject, double credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return subject + " | " + credit + " | " + grade;
    }
}

public class BOJ25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Subject[] subjects = new Subject[20];

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sub = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            subjects[i] = new Subject(sub, credit, grade);
        }

        double sum = 0.0;
        double creditSum = 0.0;

        for (int i = 0; i < subjects.length; i++) {
            if (!subjects[i].grade.equals("P")) {
                double gradepoint = 0;
                switch (subjects[i].grade) {
                    case "A+":
                        gradepoint = 4.5;
                        break;
                    case "A0":
                        gradepoint = 4.0;
                        break;
                    case "B+":
                        gradepoint = 3.5;
                        break;
                    case "B0":
                        gradepoint = 3.0;
                        break;

                    case "C+":
                        gradepoint = 2.5;
                        break;
                    case "C0":
                        gradepoint = 2.0;
                        break;
                    case "D+":
                        gradepoint = 1.5;
                        break;
                    case "D0":
                        gradepoint = 1.0;
                        break;
                    case "F":
                        gradepoint = 0.0;
                        break;
                }

//                System.out.println(subjects[i]);
                sum += gradepoint * subjects[i].credit;
                creditSum += subjects[i].credit;
//                System.out.println(sum + " , " + creditSum);
            }
        }

        System.out.println(sum / creditSum);

    }
}
