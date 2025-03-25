import java.util.Arrays;

public class test {

//    static int[] res = new int[11];
//    static boolean[] vis = new boolean[9];
//    static int[] subRes = new int[3];
//
//    public static void main(String[] args) {
//        // [2]부터 [4]까지
//        // index 숫자 세 개 합쳐서 8이 되는 조합
//
//        comb(0, 0);
//    }
//
//    private static void comb(int idx, int sum) {
//        if (idx == 3) {
//            if (sum == 8) {
//                System.out.println(Arrays.toString(subRes));
//                int subResIdx = 0;
//                for (int i = 2; i < 5; i++) {
//                    res[i] = subRes[subResIdx];
//                    subResIdx++;
//                }
//                System.out.println(Arrays.toString(res));
//            }
//            return;
//        }
//
//        for (int i = 1; i < 9; i++) {
//            if (!vis[i]) {
//                subRes[idx] = i;
//                sum += i;
//                vis[i] = true;
//                comb(idx + 1, sum);
//                vis[i] = false;
//                sum -= i;
//            }
//        }
//    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        arr = null;
        System.out.println(arr);
        int[] arr2 = {5, 6, 7, 8, 9};
        arr = arr2;
        System.out.println(Arrays.toString(arr));
    }
}
