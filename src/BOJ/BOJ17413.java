package BOJ;

import java.util.*;

public class BOJ17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] words = null;

		String s = sc.nextLine();
		// ex) < space >space space space< spa c e>

		StringTokenizer st = new StringTokenizer(s, "<>", true);

		// "<"," space ", ">", "space space space", "<", " spac c e", ">"
		// 요렇게 쪼개진 배열 만들어주기
		int n = st.countTokens();
		words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = st.nextToken();
		}

		// words 배열 요소 가공하기
		int idx = n;

		for (int i = 0; i < n; i++) {
			if (words[i].equals("<")) {
				idx = i;
			}

			else if (i == idx + 1 || i == idx + 2) {
				continue;
			}

			else {
				words[i] = reverseWord(words[i]);
			}

		}

		// 출력
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i]);
		}

	} // main

	public static String reverseWord(String str) {
		String reversedstr = "";

		// str을 토큰으로 쪼개서 배열 만들어주기
		StringTokenizer st = new StringTokenizer(str, " ", true);
		String[] tokens = new String[st.countTokens()];

		for (int j = 0; j < tokens.length; j++) {
			tokens[j] = st.nextToken();
		}
	

		// 배열에 저장된 각 토큰마다
		for (int j = 0; j < tokens.length; j++) {
			// 한 글자 한 글자 char로 배열 만들고
			char[] chars = new char[tokens[j].length()];
			for (int i = 0; i < tokens[j].length(); i++) {
				chars[i] = tokens[j].charAt(i);
			}

			// 순서 뒤집기
			for (int i = 0; i < tokens[j].length(); i++) {
				chars[i] = tokens[j].charAt(tokens[j].length() - 1 - i);
			}

			// 뒤집힌 단어 reversedWord 만들기
			String reversedWord = "";
			for (int i = 0; i < chars.length; i++) {

				reversedWord += chars[i];
			}

			reversedstr += reversedWord;
		}

		return reversedstr;
	}

}
