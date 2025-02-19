package SWEA;

import java.util.*;


public class SWEA1224_계산기3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int len = sc.nextInt();
            String str = sc.next();
            Stack<Character> op = new Stack<>();

            StringBuilder sb = new StringBuilder();

            Map<Character, Integer> map = new HashMap<>();
            map.put('(', 0);
            map.put('*', 1);
            map.put('/', 1);
            map.put('+', 2);
            map.put('-', 2);


            for (int i = 0; i < str.length(); i++) {
//				System.out.println("이제 처리해줄 위치 : " + str.charAt(i));
                // 피연산자라면 출력
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                }
                // 연산자라면
                else {
                    if (str.charAt(i) == '(')
                        op.push(str.charAt(i));

                    else if (str.charAt(i) == ')') {
                        while (op.peek() != '(') {
                            sb.append(op.pop());
                        }
                        op.pop();
                    } else {
                        if (op.isEmpty())
                            op.push(str.charAt(i));

                        else {
                            while (op.peek() != '(' && map.get(str.charAt(i)) >= map.get(op.peek())) {
                                sb.append(op.pop());
                            }
                            op.push(str.charAt(i));
                        }

                    }

                }

//				System.out.println("방금 처리해준 위치 : " + str.charAt(i));
//				System.out.println("현재 출력 : " + sb);
//				System.out.println("현재 스택 : " + op);
            }

            while (!op.isEmpty()) {
                sb.append(op.pop());
            }

//            System.out.println(sb);

            str = sb.toString();

            Stack<Integer> cal = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					cal.push(str.charAt(i) - '0');
				} else {
					int b = cal.pop();
					int a = cal.pop();

					if( str.charAt(i) == '+') {
						cal.push(a+b);
					}

					else if( str.charAt(i) == '-') {
						cal.push(a-b);
					}

					else if( str.charAt(i) == '*') {
						cal.push(a*b);
					}

					else if( str.charAt(i) == '/') {
						cal.push(a/b);
					}
				}
            }


			while (!cal.isEmpty()) {
				System.out.println("#" + t + " " +  cal.pop());
			}

        }

    }
}
