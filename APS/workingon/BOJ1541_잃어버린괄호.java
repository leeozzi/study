package workingon;

import java.io.*;

public class BOJ1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] numStr = str.split("-|\\+");
        int[] nums = new int[numStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }

//        System.out.println(Arrays.toString(nums));


    }
}
