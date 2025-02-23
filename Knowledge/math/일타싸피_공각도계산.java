package math;

public class 일타싸피_공각도계산 {
    static final double PI = 3.141592;

    public static double calculateTheta (double x1, double y1, double x2, double y2){
        // 1) my ball(내 공)과 정사영까지의 x 거리 a
        double a = x2 - x1;
        // 2) my ball(내 공)과 정사영까지의 y 거리 b
        double b = y2 + y1;
        // 3) my ball(내 공)이 법선과 벽의 교차점으로 이동하기 위한 방향 θ
        double tanTheta = a/b;
        double theta = Math.atan(tanTheta);
        return theta;
    }

    public static void main(String[] args) {
        double x1 = 1.0, y1 = 2.0;  // my ball 초기 위치
        double x2 = 5.0, y2 = 1.0;  // 목표 위치

        // θ 세타 계산
        double alpha = calculateTheta(x1, y1, x2, y2);

        // 출력 (라디안 및 도 단위 변환)
        System.out.println("my ball의 출발 각도 θ (라디안) : " + alpha);
        System.out.println("my ball의 출발 각도 θ (도) : " + (alpha * (180.0/PI)) + "도");
        System.out.println("my ball의 출발 각도 θ (도) : " + (Math.toDegrees(alpha) + "도"));
    }
}
