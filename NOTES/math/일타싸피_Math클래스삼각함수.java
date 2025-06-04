package math;

public class 일타싸피_Math클래스삼각함수 {
    public static void main(String[] args) {
        int[] start = {1,1};
        int[] end = {2,2};

        int a = Math.abs(end[0] - start[0]);    // x 좌표의 차이
        int b = Math.abs(end[1] - start[1]);    // y 좌표의 차이

        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        // arctan는 Math.atan() 메소드를 이용하면 계산할 수 있음
        // Math.atan()의 결과는 radian으로 나옴 (degree X)
        double radian = Math.atan(b/a);

        // radian을 degree로 변경해야 실제 각도를 얻을 수 있음
        System.out.printf("%f, %f", c , Math.toDegrees(radian));

    }
}
