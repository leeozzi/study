package SWEA;

import java.util.Scanner;
//import java.util.Stack;

public class SWEA8931_제로 {
	/**
	 * 제로
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T ; t++) {
			int K = sc.nextInt();
			MyStack<Integer> stack = new MyStack<>();
			
			for(int k = 0 ; k < K ; k++) {
				int num = sc.nextInt();
				if(num != 0) {
					stack.add(num);
				} else {
					stack.pop();
				}
			}
			
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
